<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="border" type="java.lang.String" %>
<%@ attribute name="evencolor" type="java.lang.String" %>
<%@ attribute name="oddcolor" type="java.lang.String" %>




<table border="${border}">
<tr>
<th>S.no</th>
<th>Userid</th>
<th>UserName</th>
</tr>


<c:if test="${sessionScope.userlist.size() ge 0}">
<c:forEach items="${sessionScope.userlist}" var="obj" varStatus="x">
<c:if test="${x.count mod 2 eq 0}">
<tr style="background-color:${evencolor} ;">
</c:if>
<c:if test="${x.count mod 2 ne 0}">
<tr style="background-color:${oddcolor} ;">
</c:if>
<td>${x.count}</td>
<td>${obj.userid}</td>
<td>${obj.userName}</td>
</tr>
</c:forEach>
</c:if>
</table>