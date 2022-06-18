package br.cefet.controller;

import java.io.IOException;

import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.ExperienceDAO;
import br.cefet.dao.PlaceVisitedDAO;
import br.cefet.model.Experience;
import br.cefet.model.PlaceVisited;
import br.cefet.model.User;

@WebServlet("/ExperienceController")
public class ExperienceController extends HttpServlet implements IController {
	private static final long serialVersionUID = 1L;

	public ExperienceController() {
		super();
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String action = String.valueOf(request.getParameter("action"));

		if (action.equals("add")) {
			this.add(request, response);
			return;
		}

		if (action.equals("remove")) {
			this.remove(request, response);
			return;
		}

		if (action.equals("list")) {
			this.listAll(request, response);
			return;
		}

		if (action.equals("listOne")) {
			this.listOne(request, response);
			return;
		}

		if (action.equals("update")) {
			this.update(request, response);
			return;
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) {
		String content = String.valueOf(request.getParameter("content"));
		int rating = Integer.valueOf(request.getParameter("rating"));
		double totalCost = Double.valueOf(request.getParameter("totalCost"));
		Date arrivalDate = Date.valueOf(request.getParameter("arrivalDate"));
		Date departureDate = Date.valueOf(request.getParameter("departureDate"));
		int idPlaceVisited = Integer.valueOf(request.getParameter("idPlaceVisited"));
		int idUser = Integer.valueOf(request.getParameter("idUser"));

		User user = new User();
		user.setId(idUser);

		PlaceVisited placeVisited = new PlaceVisited();
		placeVisited.setId(idPlaceVisited);

		Experience experience = new Experience();
		experience.setContent(content);
		experience.setRating(rating);
		experience.setTotalCost(totalCost);
		experience.setArrivalDay(arrivalDate);
		experience.setDepartureDay(departureDate);
		experience.setUser(user);
		experience.setPlaceVisited(placeVisited);

		ExperienceDAO experienceDao = new ExperienceDAO();
		experienceDao.add(experience);

		try {
			response.sendRedirect(request.getContextPath() + "/views/places-visited.jsp");
		} catch (IOException e) {
			System.out.println("Error on redirect" + e.getMessage());
		}
	}

	public void remove(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.valueOf(request.getParameter("id"));
		PlaceVisited placeVisited = new PlaceVisited();
		placeVisited.setId(id);
		PlaceVisitedDAO placeVisitedDAO = new PlaceVisitedDAO();
		placeVisitedDAO.remove(placeVisited);
	}

	public void listAll(HttpServletRequest request, HttpServletResponse response) {
		ExperienceDAO experienceDao = new ExperienceDAO();
		List<Experience> experiences = experienceDao.loadAllExperiences();
		String pageUrl = experiences == null ? "/views/sections/error.jsp" : "/views/sections/experiences.jsp";
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher(pageUrl);

			if (experiences != null) {
				request.setAttribute("experiences", experiences);
			}
			
			rd.include(request, response);

		} catch (ServletException | IOException e) {
			System.out.println("Error on include experiences");
		}
	}

	public void listOne(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.valueOf(request.getParameter("id"));
		ExperienceDAO experienceDAO = new ExperienceDAO();
		Experience experience = experienceDAO.loadExperienceById(id);

		System.out.println("Teste " + experience.getContent());
	}

	public void update(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.valueOf(request.getParameter("id"));
		String content = String.valueOf(request.getParameter("content"));
		int rating = Integer.valueOf(request.getParameter("rating"));
		double totalCost = Double.valueOf(request.getParameter("totalCost"));

		Experience experience = new Experience();
		experience.setId(id);
		experience.setContent(content);
		experience.setRating(rating);
		experience.setTotalCost(totalCost);

		ExperienceDAO experienceDAO = new ExperienceDAO();

		experienceDAO.update(experience);
	}
}
