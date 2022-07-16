package br.cefet.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/IsAdminFilter")
public class IsAdminFilter extends HttpFilter implements Filter {
	
    private static final long serialVersionUID = 1L;

	
    public IsAdminFilter() {
        super();
    }

	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user-role").toString().equals("1")) {	
			response.sendRedirect(request.getContextPath() + "/views/users/not-admin-error.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {}

}
