package com.alura.one.gerenciador.servlet;

import com.alura.one.gerenciador.accion.Accion;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

//@WebFilter(urlPatterns = "/entrada")
public class ControladorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("ControladorFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String paramAccion = request.getParameter("accion");

        String nombreClase = "com.alura.one.gerenciador.accion." + paramAccion;
        String nombre;
        try {
            Class clase = Class.forName(nombreClase);
            Object obj = clase.getDeclaredConstructor().newInstance();
            Accion accion = (Accion) obj;
            nombre = accion.ejecutar(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new ServletException(e);
        }

        String[] tipoDireccion = nombre.split(":");
        if (tipoDireccion[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoDireccion[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoDireccion[1]);
        }

    }
}
