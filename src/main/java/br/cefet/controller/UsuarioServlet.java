package br.cefet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.cefet.model.*; 
import br.cefet.dao.*;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UsuarioServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = String.valueOf(request.getParameter("login"));
		String senha = String.valueOf(request.getParameter("senha"));
		
		try {
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.adiciona(usuario);
			
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao criar usuário"  + e.getMessage());
		}
		
		System.out.println("Login value " + login);
		response.getWriter().append("Server at:" + "Teste");
	}
	
		
}
