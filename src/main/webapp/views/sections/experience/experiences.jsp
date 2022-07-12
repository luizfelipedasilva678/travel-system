<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach var="experience" items="${experiences}">
	<section class="experience__wrapper">
		<figure class="experience__image">
			<a href="/travel-system/ControlServlet?xclass=ExperienceController&action=listOne&id=${experience.getId()}" >
				<img src="${experience.getPlaceVisited().getImage()}"  />
			</a>
		</figure>
		<main class="experience__main-content">
			<p><c:out value="${experience.getContent()}"/></p>
			<p>Custo total: <c:out value="${experience.getTotalCost()}"/></p>
			<p>Avaliação: <c:out value="${experience.getRating()}"/></p>
			<p>Dia de chegada: <fmt:formatDate value="${experience.getArrivalDay()}" pattern="dd-MM-yyyy" /></p>
			<p>Dia de partida: <fmt:formatDate value="${experience.getDepartureDay()}" pattern="dd-MM-yyyy" /></p>
		</main>
		<footer class="experience__footer">
			<p>Autor: <c:out value="${experience.getUser().getLogin()}"/></p>
		</footer>
	</section>
</c:forEach>
