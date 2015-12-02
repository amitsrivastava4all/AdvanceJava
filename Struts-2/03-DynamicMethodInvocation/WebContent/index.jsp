<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DI Demo</title>
</head>
<body>
<s:form action="User" >
<s:submit />
<s:submit action="addUser" value="Add" />
<s:submit action="updateUser" value="Update" />
<s:submit action="deleteUser" value="Delete" />
</s:form>
</body>
</html>