<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:forEach var="experience" items="${experiences}">
	<section class="experience__wrapper">
		<figure class="experience__image">
			<img src="${experience.getPlaceVisited().getImage()}"  />
		</figure>
		<main class="experience__main-content">
			<p><c:out value="${experience.getContent()}"/></p>
			
		</main>
		<footer class="experience__footer">
			<p>Autor: <c:out value="${experience.getUser().getLogin()}"/></p>
		</footer>
	</section>
</c:forEach>
