
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emp Search Screen</title>
</head>
<body>
<%-- <% int count = 1; %> --%>
<form action="empsearchcontroller">
<fieldset>
<legend>Emp Search</legend>
<label for="salary">Enter Salary:</label><input type="text" id="salary" name="salary" placeholder="Type Salary Here">
<input type="submit" value="Search">
</fieldset>
</form>
	<%-- <%@ include file="empresult.jsp" %> --%>
	<%--  <jsp:include page="empresult.jsp" flush="true">
	 <jsp:param value="1" name="count"/>
	 </jsp:include> 
	 --%> <jsp:forward page="empresult.jsp">
	 
	 <jsp:param value="1" name="count"/> 
	 </jsp:forward>
</body>
</html>