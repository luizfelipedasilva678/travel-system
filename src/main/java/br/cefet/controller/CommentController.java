package br.cefet.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.CommentDAO;
import br.cefet.model.Comment;
import br.cefet.model.Experience;
import br.cefet.model.User;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet implements IController {
	private static final long serialVersionUID = 1L;

    public CommentController() {
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
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response)  {
		String content = String.valueOf(request.getParameter("content"));
		int idUser = Integer.valueOf(request.getParameter("idUsuario"));
		int idExperience = Integer.valueOf(request.getParameter("idExperience"));
		
		User user = new User();
		user.setId(idUser);
		
		Experience experience = new Experience();
		experience.setId(idExperience);
		
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setUser(user);
		comment.setExperience(experience);
			
		CommentDAO commentDao = new CommentDAO();
		commentDao.add(comment);
		
		try {
			response.sendRedirect(request.getContextPath() + "/views/login.html");
		} catch (IOException e) {
			System.out.println("Error on redirect" + e.getMessage());
		}
	}
	
	public void remove(HttpServletRequest request, HttpServletResponse response)  {
		int id = Integer.valueOf(request.getParameter("id"));
		Comment comment = new Comment();
		comment.setId(id);
		CommentDAO commentDao = new CommentDAO();
		commentDao.remove(comment);
	}
	
	public void listAll(HttpServletRequest request, HttpServletResponse response) {
		int idExperience = Integer.valueOf(request.getParameter("idExperience"));
		CommentDAO commentDao = new CommentDAO();
		List<Comment> comments = commentDao.loadAllComments(idExperience);
		
		for (Comment comment : comments) {
		    System.out.println("Oi " + comment.getContent());
		}
	}
}
