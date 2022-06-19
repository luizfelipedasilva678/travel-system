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
	<title> Experiência </title>
</head>
<body>
	<jsp:include page="/views/sections/header.jsp" flush="true"/>
	<main class="layout">
		<section class="experience__wrapper">
			<figure class="experience__image">
				<a href="/travel-system/ControlServlet?xclass=ExperienceController&action=listOne&id=${experience.getId()}" >
					<img src="${experience.getPlaceVisited().getImage()}"  />
				</a>
			</figure>
			<main class="experience__main-content">
				<p><c:out value="${experience.getContent()}"/></p>
				
			</main>
			<footer class="experience__footer">
				<p>Autor: <c:out value="${experience.getUser().getLogin()}"/></p>
			</footer>
		</section>
		<section class="experience__comments">
			<jsp:include page="/ControlServlet?action=list&xclass=CommentController" flush="true">	
				<jsp:param name="idExperience" value="${experience.getId()}"/>
			</jsp:include>
			<form id="commentRegisterForm" action="/travel-system/ControlServlet?action=add&xclass=CommentController" method="post">
				<textarea id="content" name="content" placeholder="Digite seu comentário"></textarea>
				<input type="hidden" id="idUser" name="idUser" value="<%= session.getAttribute("user-id") %>" /> 	
				<input type="hidden" id="idExperience" name="idExperience" value="${experience.getId()}"/>	
				<input  type="submit" value="Enviar"/>
			</form>
		</section>
	</main>
	<jsp:include page="/views/sections/footer.jsp" flush="true"/>
	<jsp:include page="/views/sections/menu.jsp" flush="true"/>
	
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/comments.js"></script>
</body>
</html>