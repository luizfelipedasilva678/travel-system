<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<c:forEach var="placeVisited" items="${placesVisited}">
	<c:choose>
		<c:when test="${placeVisited.getImage() != ''}">
			<section class="placeVisited__wrapper">
				<a href="/travel-system/ControlServlet?xclass=PlaceVisitedController&action=remove&id=${placeVisited.getId()}">
					<i class="bi bi-trash"></i>				
				</a>
				<button>
					<i class="bi bi-pen"></i>
				</button>
				<figure class="placeVisited__image">
					<img src="${placeVisited.getImage()}"  />
				</figure>
				<main class="placeVisited__main-content">
					<p>Nome: <c:out value="${placeVisited.getName()}"/></p>
					<p>País: <c:out value="${placeVisited.getCountry().getName()}"/></p>
				</main>
				<footer class="placeVisited__footer">
					<p>Autor: ${placeVisited.getUser().getLogin()}</p>
				</footer>
			</section>
		</c:when>
	</c:choose>
</c:forEach>