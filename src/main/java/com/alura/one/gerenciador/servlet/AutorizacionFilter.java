package com.alura.one.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("AutorizaciónFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String paramAccion = request.getParameter("accion");

        Boolean esUsuarioNoLogeado = (session.getAttribute("loginUsuario") == null);
        Boolean esUsuarioAccionProtegida = !(paramAccion.equals("Login") || paramAccion.equals("LoginForm"));

        if (esUsuarioNoLogeado && esUsuarioAccionProtegida) {
            response.sendRedirect("entrada?accion=LoginForm");
            return;
        }
        // Gracias a este filtro, se puede visualizar si es aceptado
        filterChain.doFilter(request, response);
    }
}
