<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html lang="pt-BR">
<% 
  	session = request.getSession();
    
	if(session.getAttribute("user-id") == null) {
        response.sendRedirect("/travel-system/views/login.jsp");
    }
%>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../styles/style.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
	<title>Cadastre sua experiência</title>
</head>
<body>
	<jsp:include page="/views/sections/header.jsp" flush="true"/>
	<main class="layout"> 
		<section class="form__wrapper">
			<h2 class="form__title">Cadastre sua experiência</h2>
			<form class="form" action="../ControlServlet" method="post">
				<div class="form__input-wrapper">
					<label class="form__label" for="content">Conteúdo</label>
					<textarea class="form__input" id="content" name="content" >
					</textarea>
				</div>
				<div class="form__input-wrapper">
					<label class="form__label" for="rating">Avaliação:</label>
					<input placeholder="Coloque um número entre 0 e 5" class="form__input" id="rating" min="0" max="5" name="rating" type="number"/>
				</div>
				<div class="form__input-wrapper">
					<label class="form__label" for="totalCost">Custo total:</label>
					<input class="form__input" id="totalCost" name="totalCost" />
				</div>
				<div class="form__input-wrapper">
					<label class="form__label" for="arrivalDate">Dia de chegada:</label>
					<input class="form__input" id="arrivalDate" name="arrivalDate" type="date"/>
				</div>
				<div class="form__input-wrapper">
					<label class="form__label" for="departureDate">Dia de chegada:</label>
					<input class="form__input" id="departureDate" name="departureDate" type="date"/>
				</div>
				<div class="form__input-wrapper">
					<label class="form__label" for="idPlaceVisited">Lugar visitado:</label>
					<jsp:include page="/ControlServlet?action=listByUserId&xclass=PlaceVisitedController" flush="true">	
						 <jsp:param name="userId" value="<%= session.getAttribute(\"user-id\") %>"/>
					</jsp:include>
				</div> 
				
				<input type="hidden" name="idUser" value="<%= session.getAttribute("user-id") %>"> 
				<input type="hidden" name="xclass" value="ExperienceController" />
				<input type="hidden" name="action" value="add" /> 
				
				<input class="form__submit-btn" value="Cadastrar" type="submit" />
			</form>
		</section>
	</main>	
	<jsp:include page="/views/sections/footer.jsp" flush="true"/>
	<jsp:include page="/views/sections/menu.jsp" flush="true"/>
	
	<script src="../js/main.js"></script>
</body>
</html>