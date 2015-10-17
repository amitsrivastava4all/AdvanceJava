package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Content
 */
@WebServlet(
		urlPatterns = "/content",
		initParams =
{
        @WebInitParam(name = "localemail", value = "tim@yahoo.com")
       
    })
public class Content extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Content() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramValue = this.getServletContext().getInitParameter("email");
		RequestDispatcher rd = request.getRequestDispatcher("Header");
		rd.include(request, response);
		PrintWriter out = response.getWriter();
		out.println("this is Content");
		String email = this.getServletConfig().getInitParameter("localemail");
		RequestDispatcher rd2 = request.getRequestDispatcher("Footer");
		rd2.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
