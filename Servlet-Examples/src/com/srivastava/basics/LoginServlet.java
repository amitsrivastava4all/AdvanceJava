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
		String color = request.getParameter("color");
		String favColor = null;
		PrintWriter out = response.getWriter();
		out.println("Welcome in Login Page "+userId);
		if(userId!=null && pwd!=null){
		if(userId.equals(pwd)){
			Cookie c[] = request.getCookies();
			if(c!=null && c.length>0){
				for(Cookie cc : c){
					if(cc.getName().equals("favcolor")){
						favColor = cc.getValue();
						break;
					}
				}
			}
			if(favColor==null){
			Cookie cookie = new Cookie("favcolor",color);
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
			}
			// this line create a New Session Id 
			HttpSession session = request.getSession(true);  // Creating a New Session
			session.setAttribute("user", userId);
			/*RequestDispatcher rd = request.getRequestDispatcher("welcomeuser");
			rd.forward(request, response);*/
			String newURL = response.encodeRedirectURL("welcomeuser.amit");
			// newURL = URL + JsessionID
			response.sendRedirect(newURL);
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
