package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/mylogin")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.println("Welcome in Login Page "+userId);
		if(userId!=null && pwd!=null){
		if(userId.equals(pwd)){
			// this line create a New Session Id 
			HttpSession session = request.getSession(true);  // Creating a New Session
			session.setAttribute("user", userId);
			/*RequestDispatcher rd = request.getRequestDispatcher("welcomeuser");
			rd.forward(request, response);*/
			response.sendRedirect("welcomeuser");
		}
		else
		{
			PrintWriter pw = response.getWriter();
			pw.println("Invalid Userid and Password");
			pw.close();
			
		}
		}
	}

}
