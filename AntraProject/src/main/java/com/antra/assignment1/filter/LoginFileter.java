package com.antra.assignment1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter(urlPatterns = {"/index-.jsp", "/login", "/employee", "/dept", "/menu", "/AntraAssignment_1/"})
@WebFilter("/*")
public class LoginFileter implements Filter{

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
		    	      throws IOException, ServletException {
		// TODO Auto-generated method stub
		String path = ((HttpServletRequest) req).getRequestURI();
		Cookie[] cookies = ((HttpServletRequest)req).getCookies();
		String contextPath = ((HttpServletRequest) req).getContextPath();
		HttpServletResponse httpResponse = (HttpServletResponse) resp;
		
		boolean alreadyLogin = false; 
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals("requestId")) {
					if(((HttpServletRequest)req).getSession(true).getAttribute(c.getValue()) != null)
						alreadyLogin = true;
					break;
				}
			}
		}
		System.out.println(path + ",   " + alreadyLogin);
		
		if(path.equals(contextPath + "/bundle/bundle.js")) {
			chain.doFilter(req, resp);
			return;
		}
		
		if(alreadyLogin && (path.equals(contextPath + "/login") || path.equals(contextPath + "/"))) {
			httpResponse.sendRedirect(contextPath + "/menu");
			return;
		}else if(!alreadyLogin && !path.equals(contextPath + "/login") && !path.equals(contextPath + "/")) {
			httpResponse.sendRedirect(contextPath + "/");
		}else {
			chain.doFilter(req, resp);
		}
		
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
