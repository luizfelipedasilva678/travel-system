<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<section class="comments__wrapper">
	<h2>Comentários</h2>
	<c:forEach var="comment" items="${comments}">
		<section class="comment__wrapper">
			<div class="comment__author">
				<h3><c:out value="${comment.getUser().getLogin()}"/></h3>
			</div>
			<main class="comment__main-content">
				<p><c:out value="${comment.getContent()}"/></p>
			</main>
		</section>
	</c:forEach>
</section>