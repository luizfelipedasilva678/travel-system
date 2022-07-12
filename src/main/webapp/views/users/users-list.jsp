<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
	<title> Usuários </title>
</head>
<body>
	<jsp:include page="/views/sections/general/header.jsp" flush="true"/>
	<main class="layout h-90">
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
		
	</main>
	<jsp:include page="/views/sections/general/footer.jsp" flush="true"/>
	<jsp:include page="/views/sections/general/menu.jsp" flush="true"/>
	
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/comments.js"></script>
</body>
</html>