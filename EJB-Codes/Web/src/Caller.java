

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srivastava.model.CalcBeanRemote;

/**
 * Servlet implementation class Caller
 */
@WebServlet("/Caller")
public class Caller extends HttpServlet {
	@EJB
	CalcBeanRemote remote;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = remote.add(100, 200);
		PrintWriter out = response.getWriter();
		out.println("Result is "+result);
		out.close();
	}

}
