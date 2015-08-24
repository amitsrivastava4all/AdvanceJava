package com.srivastava.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		String color = "";
		if(userid.equals(password)){
			Cookie carray[] = request.getCookies();
			for(Cookie obj: carray){
				if(obj.getName().equals("color")){
					color = obj.getValue();
					break;
				}
			}
			if(color.trim().length()==0){
			Cookie c = new Cookie("color","cyan");
			
			c.setMaxAge(60*60*24*365);
			response.addCookie(c);
			}
			HttpSession session = request.getSession(true); // Create New Session
			session.setAttribute("user", userid);
			/*RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request ,response);*/
			
			String urlWithSessionId = response.encodeRedirectURL("welcome");
			System.out.println("URL With Session ID "+urlWithSessionId);
			response.sendRedirect(urlWithSessionId);
			//response.sendRedirect("welcome?username="+userid);
		}
		else
		{
			response.sendRedirect("invalid.html");
		}
		
		
	}

}
