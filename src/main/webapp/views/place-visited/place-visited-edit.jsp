<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="pt-BR">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	<title>Atualizar lugar visitado</title>
</head>
<body>
	<% %>
	<jsp:include page="/views/sections/general/header.jsp" flush="true"/>
	<main class="layout"> 
		<section class="form__wrapper">
			<h2 class="form__title">Atualizar lugar visitado</h2>
			<form class="form" action="${pageContext.request.contextPath}/ControlServlet" method="post" enctype="multipart/form-data">
				<div class="form__input-wrapper">
					<label class="form__label" for="name">Nome:</label>
					<input class="form__input" id="name" name="name" type="text" value="${placeVisited.getName()}"/>
				</div>
				<div class="form__input-wrapper">
					<label class="form__label-file-input" for="file">Coloque sua imagem aqui</label>
					<input class="form__input" id="file" name="file" type="file"/>
				</div>
				
				<input type="hidden" name="id" value="${placeVisited.getId()}"> 
				<input type="hidden" name="xclass" value="PlaceVisitedController" />
				<input type="hidden" name="action" value="update" /> 
				
				<input class="form__submit-btn" value="Atualizar" type="submit" />
			</form>
		</section>
	</main>	
	<jsp:include page="/views/sections/general/footer.jsp" flush="true"/>
	<jsp:include page="/views/sections/general/menu.jsp" flush="true"/>
	
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>