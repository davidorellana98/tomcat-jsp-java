package com.alura.one.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class MonitoreoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long antes = System.currentTimeMillis();
        System.out.println("MonitoreoFilter");

        String accion = request.getParameter("accion");
        // Ejecucion del controlador
        chain.doFilter(request, response);

        long despues = System.currentTimeMillis();
        System.out.println("Timepo de ejecucion: " + accion + " -> " + (despues - antes));

    }
}
