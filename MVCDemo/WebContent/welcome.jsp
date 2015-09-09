<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="amit" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<amit:head/>
</head>
<body>
<h1>Welcome ${sessionScope.user} <%-- <%=session.getAttribute("user") %> --%></h1>
Users Are <%-- ${sessionScope.userlist.size()} --%>
<%-- ${sessionScope.userlist} --%>
<amit:tableprint border="2" evencolor="red" oddcolor="cyan"/>
<amit:date id="dob"/>
</body>
</html>