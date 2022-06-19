package br.cefet.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.CountryDAO;
import br.cefet.model.Country;


@WebServlet("/CountryController")
public class CountryController extends HttpServlet implements IController {
	private static final long serialVersionUID = 1L;

	public CountryController() {
		super();
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String action = String.valueOf(request.getParameter("action"));

		if (action.equals("list")) {
			this.listAll(request, response);
			return;
		}

	}

	public void listAll(HttpServletRequest request, HttpServletResponse response) {
		CountryDAO countryDao = new CountryDAO();
		List<Country> countries = countryDao.loadAllCountries();

		try {
			RequestDispatcher rd = request.getRequestDispatcher("/views/sections/select-countries.jsp");
			request.setAttribute("countries", countries);
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Error on include experiences");
		}
	}
}
