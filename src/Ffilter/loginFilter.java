package Ffilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class loginFilter
 */
/*
 * @WebFilter("/studentLogin")
 */

public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
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
		   PrintWriter out=response.getWriter();  
	          
		    String email=request.getParameter("emails");  
			String idF=request.getParameter("passS");

			String type=request.getParameter("gender");
			

		    if(email!=null &&idF!=null && type!=null){  
		    chain.doFilter(request, response);//sends request to next resource  
		    }  
		    else{  
		    out.print("username or password error!");  
		    RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
		    rd.include(request, response);  
		    }  

		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
