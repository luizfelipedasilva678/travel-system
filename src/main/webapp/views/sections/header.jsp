<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="header">
	<button class="menu menu-btn">
		<i class="menu-btn bi bi-list" ></i>
	</button>
	<h1>Registro de viagens</h1>
	<% 
	  	session = request.getSession();
	    
		if(session.getAttribute("user-id") != null) {
	        response.sendRedirect("/travel-system/views/login.jsp");
	%>
			<a class="logout-btn" href="/travel-system/ControlServlet?action=logout&xclass=UserController">Logout</a>
	 <% } %>	
</header>