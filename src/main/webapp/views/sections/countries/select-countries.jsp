<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<select name="idCountry" id="idCountry">
	<c:forEach var="country" items="${countries}">
		<option value="${country.getId()}">${country.getName()}</option>
	</c:forEach>
</select>
    