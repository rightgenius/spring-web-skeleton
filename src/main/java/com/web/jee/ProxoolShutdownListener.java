package com.web.jee;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.logicalcobwebs.proxool.ProxoolFacade;


public class ProxoolShutdownListener implements ServletContextListener {
	

	 /**
     * {@inheritDoc}
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
    }

    /**
     * should shutdown proxool
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    	ProxoolFacade.shutdown(1000);
    }

}
