<%@page import="com.srivastava.mvc.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%
/* int count = 1; */
Integer count = Integer.parseInt(request.getParameter("count"));
count++; 
int counter = 1;
String color = "red";
boolean isTraverse = false;
ArrayList<EmployeeDTO> empList = (ArrayList<EmployeeDTO>)request.getAttribute("emplist");

if(empList!=null ){
%>
Count is <%=count %> 
<table border="1">
<tr>
<th>EmployeeNo</th>
<th>Name</th>
<th>Salary</th>
</tr>
<%
for(EmployeeDTO empObject : empList){
	isTraverse = true;
	if(counter%2==0){
		color="yellow";
	}
	else
	{
		color="red";
	}
	counter++;
%>
<tr style="background-color: <%=color%>">
<td><%=empObject.getId() %></td>
<td><%=empObject.getName() %></td>
<td><%=empObject.getSalary() %></td>
</tr>
<%
}
if(!isTraverse){
%>
<tr><td colspan="3">No Record Found....</td></tr>
<%} %>
</table>
<%
}
%>