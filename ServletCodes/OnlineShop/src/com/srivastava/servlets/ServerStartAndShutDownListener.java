package com.srivastava.servlets;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndShutDownListener
 *
 */
@WebListener
public class ServerStartAndShutDownListener implements ServletContextListener {
public static ArrayList<Integer> list = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public ServerStartAndShutDownListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         for(int i = 1 ; i<=100 ; i++){
        	 System.out.println("I is "+i);
        	 try {
        		 list.add(i);
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
    }
	
}
