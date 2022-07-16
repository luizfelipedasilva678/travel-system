<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:choose>
	<c:when test="${experiences.size() == 0}">
		<section class="error-page">
			<h2>Parece que você não tem nenhuma experiência cadastrada :( </h2>
		</section>
	</c:when>
	<c:when test="${experiences.size() != 0}">
		<c:forEach var="experience" items="${experiences}">
			<section class="experience__wrapper">
				<div class="placeVisited__actions">
					<a class="action-icon" href="/travel-system/ControlServlet?xclass=ExperienceController&action=remove&id=${experience.getId()}">
						<i class="bi bi-trash"></i>				
					</a>
					<a class="action-icon" href="/travel-system/ControlServlet?xclass=ExperienceController&action=dataForEditPage&id=${experience.getId()}">
						<i class="bi bi-pen"></i>
					</a>
				</div>
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
	</c:when>
</c:choose>
