package br.cefet.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.cefet.dao.PlaceVisitedDAO;
import br.cefet.model.Country;
import br.cefet.model.PlaceVisited;
import br.cefet.model.User;

@WebServlet("/PlaceVisitedController")
public class PlaceVisitedController extends HttpServlet implements IController {
	private static final long serialVersionUID = 1L;
       
   
    public PlaceVisitedController() {
        super();
    }
    
    public String fileUpload(HttpServletRequest request) {
    	try {
    		Part filePart = request.getPart("file");
    		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
    		InputStream fileContent = filePart.getInputStream();
    		File uploads = new File(System.getProperty("user.dir") + "/eclipse-workspace/travel-system/src/main/webapp/static");
    		File file = new File(uploads, fileName);
    		Files.copy(fileContent, file.toPath());
    		
    		
    		return "/travel-system/static/" + fileName;
    		
    	} catch(Exception e) {
    		e.getStackTrace();
    		System.out.println("Error on upload file" + e.getMessage());
    		
    		return "";
    	}
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) {
		String action = String.valueOf(request.getParameter("action"));
		
		if(action.equals("add")) {
			this.add(request, response);
			return;
		}
	}
    
    public void add(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		String image = this.fileUpload(request);
    		String name = String.valueOf(request.getParameter("name"));
    		int idCountry = Integer.valueOf(request.getParameter("idCountry"));
    		int idUser = Integer.valueOf(request.getParameter("idUser"));
    		User user = new User();
    		user.setId(idUser);
    	    		
    		Country country = new Country();
    		country.setId(idCountry);
    		
    		PlaceVisited placeVisited = new PlaceVisited();
    		placeVisited.setImage(image);
    		placeVisited.setName(name);
    		placeVisited.setUser(user);
    		placeVisited.setCountry(country);
    		
    		PlaceVisitedDAO placeVisitedDao = new PlaceVisitedDAO();
    		placeVisitedDao.add(placeVisited);
    			    
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Error on upload file " + e.getMessage());
    	}
       
    }
    
}
