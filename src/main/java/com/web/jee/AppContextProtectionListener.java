package com.web.jee;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class AppContextProtectionListener implements ServletContextListener {
	

	 /**
     * Init AppContext using root ClassLoader to prevent memory leak
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
    	try {
    		 final ClassLoader active = Thread.currentThread().getContextClassLoader();
    		 try {
    		  //Find the root classloader
    		  ClassLoader root = active;
    		  while (root.getParent() != null) {
    		   root = root.getParent();
    		  }
    		  //Temporarily make the root class loader the active class loader
    		  Thread.currentThread().setContextClassLoader(root);
    		  //Force the AppContext singleton to be created and initialized
    		  sun.awt.AppContext.getAppContext();
    		 } finally {
    		  //restore the class loader
    		  Thread.currentThread().setContextClassLoader(active);   
    		 }
    		} catch ( Throwable t) {
    		 //Carry on if we get an error
    		}
    }

	 /**
     * {@inheritDoc}
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

}
