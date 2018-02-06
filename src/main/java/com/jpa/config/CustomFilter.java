package com.jpa.config;

import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Component
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("Init :: Called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    {
        System.out.println("DoFilter :: Called");

        HttpServletRequest request = (HttpServletRequest)servletRequest;

        Principal userPrincipal = request.getUserPrincipal();
        System.out.println("User Principle: "+ userPrincipal);
    }

    @Override
     public void destroy()
    {
        System.out.println("Destroy :: Called");
    }
}
