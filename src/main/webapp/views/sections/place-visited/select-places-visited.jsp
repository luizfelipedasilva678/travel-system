<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:choose>
	<c:when test="${placesVisited.size() == 0}">
		<a class="register-place-link" href="/travel-system/views/place-visited/place-visited-register.jsp">Cadastre um lugar visitado primeiro</a>
	</c:when>
	<c:when test="${placesVisited.size() > 0}">
		<select name="idPlaceVisited" id="idPlaceVisited">
			<c:forEach var="placeVisited" items="${placesVisited}">
				<option value="${placeVisited.getId()}">${placeVisited.getName()}</option>
			</c:forEach>
		</select>	
	</c:when>
</c:choose>


    