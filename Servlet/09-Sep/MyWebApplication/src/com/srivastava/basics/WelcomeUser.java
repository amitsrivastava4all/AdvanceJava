package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeUser
 */
@WebServlet("/welcomeuser")
public class WelcomeUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html> <html> <head> "+
				" <meta charset='ISO-8859-1'> "+
				" <title>Insert title here</title> "+
				" </head> "+
				" <body> "+
				" Welcome  "+userid+
				" </body> "+
				" </html>");
		
	}

}
