<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1 style="color: red;">${requestScope.errormsg}</h1>
<%-- <%
String errorMsg = (String)request.getAttribute("errormsg");
if(errorMsg!=null && errorMsg.trim().length()>0){
	

%>
<h1 style="color: red;"><%=errorMsg %></h1>
<%
}
%> --%>
<form action="LoginController" method="post">
<input type="text" name="userid">
<input type="Password" name="pwd">
<input type="submit">
</form>
</body>
</html>