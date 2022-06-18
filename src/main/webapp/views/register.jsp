<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../styles/style.css"/>
	<title>Cadastre-se</title>
</head>
<body>
	<jsp:include page="/views/sections/header.jsp" flush="true"/>
	<main class="layout"> 
		<section class="form__wrapper">
			<h2 class="form__title">Cadastre-se</h2>
			<form class="form" action="../ControlServlet" method="post">
				<div class="form__input-wrapper">
					<label class="form__label" for="login">Login:</label>
					<input class="form__input" id="login" name="login" type="text"/>
				</div>
				<div class="form__input-wrapper">
					<label class="form__label" for="senha">Senha:</label>
					<input class="form__input" id="password" name="password" type="password"/>
				</div>
				
				<input type="hidden" name="xclass" value="UserController" />
				<input type="hidden" name="action" value="add" /> 
				
				<input class="form__submit-btn" value="Registrar" type="submit" />
			</form>
		</section>
	</main>	
	<jsp:include page="/views/sections/footer.jsp" flush="true"/>
</body>
</html>