package com.srivastava.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowProducts
 */
@WebServlet("/displayproducts.shop")
public class ShowProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		/*if(session==null){
			response.sendRedirect("login.html");
		}
		else{*/
		String email = this.getServletConfig().getInitParameter("email");
		String tollFree = this.getServletConfig().getServletContext().getInitParameter("tollfreenumber");
		
		PrintWriter out = response.getWriter();
		out.println("Welcome "+session.getAttribute("user"));
		out.println("Email "+email +" TollFree Number "+tollFree);
		out.println(" Display Products");
		session.removeAttribute("user");
		session.invalidate();
		//}
	}

}
