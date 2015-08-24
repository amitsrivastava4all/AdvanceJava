package com.srivastava.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = "";
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false); // Use Existing Session
		Cookie carray[] = request.getCookies();
		for(Cookie obj: carray){
			if(obj.getName().equals("color")){
				color = obj.getValue();
				break;
			}
		}
		if(session==null){
			response.sendRedirect("login.html");
		}
		else{
		String userid =(String)session.getAttribute("user");
			//String userid = request.getParameter("userid");
		//String userid = request.getParameter("username");
		out.println("<html><body bgcolor="+color+">");
		out.println("Welcome "+userid);
		out.println("</body></html>");
		out.close();
		}
	}

}
