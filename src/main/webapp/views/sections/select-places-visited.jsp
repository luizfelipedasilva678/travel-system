<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<select name="idPlaceVisited" id="idPlaceVisited">
	<c:forEach var="placeVisited" items="${placesVisited}">
		<option value="${placeVisited.getId()}">${placeVisited.getName()}</option>
	</c:forEach>
</select>
    