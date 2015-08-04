import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class MyServlet extends HttpServlet
{
String msg = "";


@Override
public void init(){
msg = "I will Call Only Once... ";
}

@Override
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException , ServletException
{
PrintWriter out = res.getWriter();
out.println("Hello Client  "+msg);
out.close();
}

@Override
public void destroy(){
System.out.println("Destroy Called....");
}


}