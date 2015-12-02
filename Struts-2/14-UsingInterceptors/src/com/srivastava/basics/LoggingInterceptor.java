package com.srivastava.basics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoggingInterceptor implements Interceptor{
		 
	    private static final long serialVersionUID = 1L;
	 
	    public String intercept(ActionInvocation invocation) throws Exception {
	    	
	        String className = invocation.getAction().getClass().getName();
	        long startTime = System.currentTimeMillis();
	        System.out.println("Before calling action: " + className);
	 
	        String result = invocation.invoke(); // This will invoke the action
	 
	        long endTime = System.currentTimeMillis();
	        System.out.println("After calling action: " + className
	                + " Time taken: " + (endTime - startTime) + " ms");
	 
	        return result;
	    }
	 
	    public void destroy() {
	        System.out.println("Destroying MyLoggingInterceptor...");
	    }
	    public void init() {
	        System.out.println("Initializing MyLoggingInterceptor...");
	    }
}
