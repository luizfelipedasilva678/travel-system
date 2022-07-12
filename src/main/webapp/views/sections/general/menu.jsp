<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="menu-container d-none">
	<% 
		session = request.getSession();	
	%>
	<button class="menu-container__btn-close menu-btn-close">
		<i class="menu-btn-close bi bi-x"></i>
	</button>
	<ul>
		<li>
			<a href="/travel-system" class="menu-container__ul-submenu"> Voltar para home </a>
		</li>
		<% 
			if(session.getAttribute("user-id") == null) {
		%>
	    	<li>
				<a href="/travel-system/views/login-and-register/login.jsp" class="menu-container__ul-submenu"> Fazer login </a>
			</li>
	    <% } else { %>
	    	<li>
				<a href="/travel-system/ControlServlet?action=logout&xclass=UserController" class="menu-container__ul-submenu"> Fazer logout </a>
			</li>
	    <% } %>
		<li>
			<a href="#" class="menu-container__ul-submenu"> Lugares visitados <i class="bi bi-caret-down-fill"></i> </a>
			<ul class="menu-container__ul-submenu-menu d-none">
				<li><a href="/travel-system/views/place-visited/place-visited-register.jsp" class="menu-container__ul-submenu-item">Cadastrar lugar visitado</a></li>
				<li><a href="/travel-system/views/place-visited/place-visited-list.jsp" class="menu-container__ul-submenu-item">Listar lugares visitados</a></li>
				<% 
					if(session.getAttribute("user-id") != null) {
				%>
					<li><a href="/travel-system/views/place-visited/user-place-visited.jsp" class="menu-container__ul-submenu-item">Listar meus lugares visitados</a></li>	
				<% } %>
			</ul>
		</li>
		<li>
			<a href="#" class="menu-container__ul-submenu"> Experiências <i class="bi bi-caret-down-fill"></i> </a>
			<ul  class="menu-container__ul-submenu-menu d-none">
				<li><a href="/travel-system/views/experience/experience-register.jsp" class="menu-container__ul-submenu-item">Cadastrar experiências </a></li>
				<li><a href="/travel-system" class="menu-container__ul-submenu-item">Listar experiências </a></li>
				<% 
					if(session.getAttribute("user-id") != null) {
				%>
					<li><a href="/travel-system/views/experience/user-experience.jsp" class="menu-container__ul-submenu-item">Listar minhas experiências</a></li>	
				<% } %>
			</ul>
		</li>
	</ul>
</nav>