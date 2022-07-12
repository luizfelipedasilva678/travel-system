package br.cefet.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControlServlet")
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, 
  maxFileSize = 1024 * 1024 * 10,      
  maxRequestSize = 1024 * 1024 * 100 
)
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ControlServlet() {
        super();
    }
    
    public void init(HttpServletRequest request, HttpServletResponse response) {	
    	String name = String.valueOf(request.getParameter("xclass"));
		String className = "br.cefet.controller." + name;
			
		try {
			Class<?> classInstance = Class.forName(className);
			IController servlet = (IController) classInstance.getDeclaredConstructor().newInstance();
			servlet.execute(request, response);
		} catch(Exception e) {
			System.out.println("Error " + e.getMessage());
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.init(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.init(request, response);
	}

}
