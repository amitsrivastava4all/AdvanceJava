<%@ page language="java" contentType="text/html;" import="java.util.Date"
     pageEncoding="UTF-8" autoFlush="true" buffer="8kb" errorPage="customerror.jsp"
    info="created by " isErrorPage="false" isThreadSafe="true" session="true"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
 <%
int ee = 10/0;
%> 
<h1>
Date Data is 
<%-- <%
Date d = new Date();
out.println(d);
%> --%>
<%! int x ; //Instance var %>
<%
int a = 100;  // Local Var
int b = 200;
int c =  a + b;
x++;  // X Get Incremented in Each Call 
//out.println("sum is "+c);
%>
<%! public void show(){ 

}
%>

<h1>No Of times Page Visited <%=x %> </h1> 
<h2>Sum is <%=c %></h2>
<%=new Date() %>
</h1>
<%if(100>20){ %>
<h1>Hello</h1>
<h2>Hi</h2>
<%
}
JspWriter o = pageContext.getOut();
o.println("Hello");
%>
</body>
</html>