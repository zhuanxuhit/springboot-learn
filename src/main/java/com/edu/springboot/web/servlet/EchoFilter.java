package com.edu.springboot.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhuanxu
 */
public class EchoFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("echo filter income host: " + request.getRemoteAddr());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
