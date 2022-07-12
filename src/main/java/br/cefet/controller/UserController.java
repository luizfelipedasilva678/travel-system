package br.cefet.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.dao.UserDAO;
import br.cefet.model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet implements IController {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String action = String.valueOf(request.getParameter("action"));
		
		if(action.equals("add")) {
			this.add(request, response);
			return;
		}
		
		if(action.equals("remove")) {
			this.remove(request, response);
			return;
		}
		
		if(action.equals("list")) {
			this.listAll(request, response);
			return;
		}
		
		if(action.equals("listOne")) {
			this.listOne(request, response);
			return;
		}
		
		if(action.equals("update")) {
			this.update(request, response);
			return;
		}
		
		if(action.equals("login")) {
			this.login(request, response);
			return;
		}
		
		if(action.equals("logout")) {
			this.logout(request, response);
			return;
		}
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response)  {
		String login = String.valueOf(request.getParameter("login"));
		String password = String.valueOf(request.getParameter("password"));
		User user = new User(login, password);
		UserDAO userDao = new UserDAO();
		userDao.add(user);
		
		try {
			response.sendRedirect(request.getContextPath() + "/views/login-and-register/login.jsp");
		} catch (IOException e) {
			System.out.println("Error on redirect" + e.getMessage());
		}
	}
	
	public void remove(HttpServletRequest request, HttpServletResponse response)  {
		int id = Integer.valueOf(request.getParameter("id"));
		User user = new User();
		user.setId(id);
		UserDAO userDao = new UserDAO();
		userDao.remove(user);
	}
	
	public void listAll(HttpServletRequest request, HttpServletResponse response) {
		UserDAO userDao = new UserDAO();
		List<User> users = userDao.loadAllUsers();
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/views/users/users-list.jsp");
			request.setAttribute("users", users);
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Error on include users");
		}
	}
	
	public void listOne(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.valueOf(request.getParameter("id"));
		UserDAO userDao = new UserDAO();
		User user = userDao.loadUserById(id);
		
		System.out.println("Teste " + user.getLogin() + " " + user.getPassword());
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.valueOf(request.getParameter("id"));
		String login = String.valueOf(request.getParameter("login"));
		String password = String.valueOf(request.getParameter("password"));		
		User user = new User(id, password, login);
		UserDAO userDao = new UserDAO();
		userDao.update(user);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String login = String.valueOf(request.getParameter("login"));
		String password = String.valueOf(request.getParameter("password"));		
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		
		UserDAO userDao = new UserDAO();
		User loggedUser = userDao.login(user);
		
		if(loggedUser == null) {
			try {
				response.sendRedirect(request.getContextPath() + "/views/login-and-register/login.jsp");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(loggedUser != null) {	
			HttpSession session;
			session = request.getSession();
			session.setAttribute("user-id", loggedUser.getId());
			session.setAttribute("user-login", loggedUser.getLogin());
				
			try {
				response.sendRedirect(request.getContextPath());
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) {
	    HttpSession session = request.getSession();  
        session.invalidate();  
        
        
        try {
			response.sendRedirect(request.getContextPath() + "/views/login-and-register/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
