package com.srivastava.basics;

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
 * Servlet implementation class WelcomeUser
 */
@WebServlet("/welcomeuser.amit")
public class WelcomeUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String userid = request.getParameter("userid");
		// Picking the existing Session Id
		HttpSession session = request.getSession(false);
		//session.invalidate();
		String favColor = null;
		// Not Having the Session
		/*if(session == null){
			response.sendRedirect("login.html");
		}
		else{*/
		String userid = (String)session.getAttribute("user");
		Cookie c[] = request.getCookies();
		if(c!=null && c.length>0){
			for(Cookie cc : c){
				if(cc.getName().equals("favcolor")){
					favColor = cc.getValue();
					break;
				}
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html> <html> <head> "+
				" <meta charset='ISO-8859-1'> "+
				" <title>Insert title here</title> "+
				" </head> "+
				" <body bgcolor='"+favColor+"'> "+
				" Welcome  "+userid+" Login Count "+SessionTestListener.counter+
				" </body> "+
				" </html>");
		
	//}
	}

}
