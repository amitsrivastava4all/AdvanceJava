package com.srivastava.mvc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpControllerServlet
 */
@WebServlet("/empsearchcontroller")
public class EmpControllerServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double salary = Double.parseDouble(request.getParameter("salary"));
		EmployeeModel model = new EmployeeModel();
		try {
			ArrayList<EmployeeDTO> empList = model.searchBySalary(salary);
			request.setAttribute("emplist", empList);
			request.getRequestDispatcher("empsearch.jsp")
			.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
		
	}

}
