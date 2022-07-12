<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../../styles/style.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css"/>
	<title>Locais visitados</title>
</head>
<body>
	<jsp:include page="/views/sections/general/header.jsp" flush="true"/>
	<main class="layout">
		<jsp:include page="/ControlServlet?action=list&xclass=PlaceVisitedController" flush="true"/>	
	</main>
	<jsp:include page="/views/sections/general/footer.jsp" flush="true"/>
	<jsp:include page="/views/sections/general/menu.jsp" flush="true"/>
	
	<script src="../../js/main.js"></script>
</body>
</html>