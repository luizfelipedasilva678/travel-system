package br.cefet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/AuthenticatedFilter")
public class AuthenticatedFilter extends HttpFilter implements Filter {
       
    
    private static final long serialVersionUID = 1L;


	public AuthenticatedFilter() {
        super();
    }


	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user-id") == null) {
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}
}
