package ap.adm.phd.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(filterName = "/AuthenticationFilter",urlPatterns = {"/*"},asyncSupported=true)
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 	HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        String uri = req.getRequestURI();
	        System.out.println("[INFO] Filter Call , URI:"+uri);
	         
	        HttpSession session = req.getSession();
	        if(uri.endsWith("html")) 
	        	res.sendError(404);
	        else if((session.getAttribute("logged_in_user") != null && (Boolean)session.getAttribute("logged_in_user") == true) && uri.contains("UserSessionManager"))
	        {
	        	System.out.println("[INFO] User already logged in!");
	        	res.sendRedirect("UserController");
	        	return;
	        }
	        else if((session.getAttribute("logged_in_user") != null && (Boolean)session.getAttribute("logged_in_user") == true) && uri.contains("AdminController")){
	        	if (!session.getAttribute("guser_email").equals("rounaq14089@iiitd.ac.in")) res.sendRedirect("SessionDestroy");
	        	else chain.doFilter(request, response);
	        }
	        else if((session.getAttribute("logged_in_user") == null || (Boolean)session.getAttribute("logged_in_user") == false)  && (uri.contains("UserController") || uri.contains("AdminController")))
	        {
	        	System.out.println("[INFO] User not logged in! / Successfully Logged out");
	            res.sendRedirect("UserSessionManager");
	            return;
	        }
	        else
	        {
	            // pass the request along the filter chain
	            chain.doFilter(request, response);
	        }
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
