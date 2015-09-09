

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		LoginModel model = new LoginModel();
		boolean isFound = model.isUserExist(userid, password);
		if(isFound){
			HttpSession session = request.getSession(true);
			ArrayList<LoginDTO> userList = new ArrayList<>();
			for(int i = 1 ; i<=10 ; i++){
				LoginDTO loginDTO = new LoginDTO();
				loginDTO.setUserid(userid);
				loginDTO.setUserName(userid+i);
				userList.add(loginDTO);
			}
			session.setAttribute("user", userid);
			session.setAttribute("userlist", userList);
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			request.setAttribute("errormsg", "Invalid Userid or Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
