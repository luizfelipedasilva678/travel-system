<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:forEach var="placeVisited" items="${placesVisited}">
	<section class="placeVisited__wrapper">
		<figure class="placeVisited__image">
			<img src="${placeVisited.getImage()}"  />
		</figure>
		<main class="placeVisited__main-content">
			<p><c:out value="${placeVisited.getName()}"/></p>
			
		</main>
		<footer class="placeVisited__footer">
			<p>Autor: </p>
		</footer>
	</section>
</c:forEach>
