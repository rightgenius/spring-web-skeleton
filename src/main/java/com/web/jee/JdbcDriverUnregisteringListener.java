package com.web.jee;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;


public class JdbcDriverUnregisteringListener implements ServletContextListener {
	
	private Logger logger;

	 /**
     * {@inheritDoc}
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger = LoggerFactory.getLogger(getClass());
        deregisterDrivers(getDrivers());
        
        shutdownCleanupThread();
    }
    
    /**
     * This is somehow a mysql driver bug: http://bugs.mysql.com/bug.php?id=69526
     * This can cause memory leak in web containers.
     * The function is a possible fix: http://stackoverflow.com/questions/11872316/tomcat-guice-jdbc-memory-leak
     */
    void shutdownCleanupThread(){
    	try {
    	    AbandonedConnectionCleanupThread.shutdown();
    	} catch (InterruptedException e) {
    	    logger.warn("SEVERE problem cleaning up: " + e.getMessage());
    	    e.printStackTrace();
    	}
    }

    /**
     * Retrieves an Enumeration with all of the currently loaded JDBC drivers.
     *
     * @return the list of JDBC Drivers
     */
    Enumeration<Driver> getDrivers() {
        return DriverManager.getDrivers();
    }

    /**
     * Unregistering JDBC drivers given as param.
     *
     * @param drivers {@link Enumeration} of {@link Driver} to unregister
     */
    void deregisterDrivers(Enumeration<Driver> drivers) {
        while (drivers.hasMoreElements()) {
            deregisterDriver(drivers.nextElement());
        }
    }

    /**
     * Unregistering single JDBC driver given as param.
     *
     * @param driver to unregister
     */
    void deregisterDriver(Driver driver) {
        try {
            DriverManager.deregisterDriver(driver);
            logger.info("Deregistering JDBC driver: {}", driver);
        } catch (SQLException e) {
            logger.warn("Error deregistering JDBC driver: {}. Root cause: ", driver, e);
        }
    }
}
