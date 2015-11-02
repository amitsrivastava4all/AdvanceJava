<%@page import="com.srivastava.mvc.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emp Search Screen</title>
</head>
<body>
<form action="empsearchcontroller">
<fieldset>
<legend>Emp Search</legend>
<label for="salary">Enter Salary:</label><input type="text" id="salary" name="salary" placeholder="Type Salary Here">
<input type="submit" value="Search">
</fieldset>
</form>
<c:if test="${not empty emplist  }">
<table border="1">

<tr>
<th>S.no</th>
<th>Empno</th>
<th>Name</th>
<th>Salary</th>
</tr>
<%-- <c:set var="isTraverse" value="false"/> --%>
<c:forEach items="${emplist}" var="obj" varStatus="x">
 
 
<c:if test="${ x.count mod 2 eq 0}">
 <c:set var="color" value="red"/>
</c:if>
<c:if test="${ x.count mod 2 ne 0}">
 <c:set var="color" value="yellow"/>
</c:if>

<tr style="background-color: ${color}">
<td>${x.count}</td>
<td>${obj.id}</td>
<td>${obj.name}</td>
<td>${obj.salary}</td>
</tr>
</c:forEach>

<%-- <c:if test="${isTraverse eq false}">
<tr><td colspan="3">No Record Found....</td></tr>
</c:if> --%>
</table>
</c:if>

</body>
</html>