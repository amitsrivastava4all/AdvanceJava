package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String pwd = request.getParameter("password");
		if(userId.equals(pwd)){
			RequestDispatcher rd = request.getRequestDispatcher("welcomeuser");
			rd.forward(request, response);
			//response.sendRedirect("welcomeuser?uid="+userId);
		}
		else
		{
			PrintWriter pw = response.getWriter();
			pw.println("Invalid Userid and Password");
			pw.close();
			
		}
	}

}
