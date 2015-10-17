package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadDemo
 */
@WebServlet( urlPatterns = "/loaddemo",
loadOnStartup = 1)
public class LoadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList list ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDemo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(){
    	// JDBC Call Code Fill Array
    	list = new ArrayList();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramValue = this.getServletContext().getInitParameter("email");
		PrintWriter out = response.getWriter();
		out.println(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
