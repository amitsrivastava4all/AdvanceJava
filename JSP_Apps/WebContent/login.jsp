<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
String userid = request.getParameter("userid");
String password = request.getParameter("pwd");
if(userid!=null && password!=null){
if(userid.equals(password))
{
	response.sendRedirect("https://www.google.com");
}
else{
%>
<b>Invalid Userid and Password</b>
<%
}
}
%>
<form method="post" action="login.jsp">
<label>Userid</label>
<input type="text" name="userid"/>
<br>
<label>Password</label>
<input type="password" name="pwd"/>
<br>
<input type="submit"/>
<input type="reset"/>
</form>
<jsp:plugin code="" codebase="" type="applet">
<jsp:fallback></jsp:fallback>
</jsp:plugin>
<jsp:forward page="footer.jsp"/>
</body>
</html>

