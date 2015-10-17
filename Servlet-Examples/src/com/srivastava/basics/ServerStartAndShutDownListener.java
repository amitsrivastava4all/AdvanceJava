package com.srivastava.basics;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndShutDownListener
 *
 */
@WebListener
public class ServerStartAndShutDownListener implements ServletContextListener {

    
    public ServerStartAndShutDownListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
         for(int i = 1 ; i<=200; i++){
        	 System.out.println("I is "+i);
        	 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
    }
	
}
