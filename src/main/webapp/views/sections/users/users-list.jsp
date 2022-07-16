<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<table>
<tr> 
	<th> Id </th>
	<th> Login </th>
	<th> Password </th>
</tr>
	<c:forEach var="user" items="${users}">
		<tr> 
			<td> ${user.getId()} </td>
			<td> ${user.getLogin()} </td>
			<td> ${user.getPassword()} </td>
		</tr>
	</c:forEach>
</table>