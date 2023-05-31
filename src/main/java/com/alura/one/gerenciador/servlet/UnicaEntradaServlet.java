package com.alura.one.gerenciador.servlet;

import com.alura.one.gerenciador.accion.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramAccion = req.getParameter("accion");
//        HttpSession session = req.getSession();
//
//        Boolean esUsuarioNoLogeado = (session.getAttribute("loginUsuario") == null);
//        Boolean esUsuarioAccionProtegida = !(paramAccion.equals("Login") || paramAccion.equals("LoginForm"));
//
//        if (esUsuarioNoLogeado && esUsuarioAccionProtegida) {
//            resp.sendRedirect("entrada?accion=LoginForm");
//            return;
//        }

        String nombreClase = "com.alura.one.gerenciador.accion." + paramAccion;
        String nombre;
        try {
            Class clase = Class.forName(nombreClase);
            Object obj = clase.getDeclaredConstructor().newInstance();
            Accion accion = (Accion) obj;
            nombre = accion.ejecutar(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new ServletException(e);
        }

        String[] tipoDireccion = nombre.split(":");
        if (tipoDireccion[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoDireccion[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(tipoDireccion[1]);
        }

        /*if (paramAccion.equals("ListaEmpresas")) {
            ListaEmpresas accion = new ListaEmpresas();
            nombre = accion.ejecutar(req, resp);
        } else if (paramAccion.equals("MostrarEmpresa")){
            MostrarEmpresa accion = new MostrarEmpresa();
            nombre = accion.ejecutar(req, resp);
        } else if (paramAccion.equals("EliminarEmpresa")) {
            EliminarEmpresa accion = new EliminarEmpresa();
            nombre = accion.ejecutar(req, resp);
        } else if (paramAccion.equals("ModificarEmpresa")) {
            ModificarEmpresa accion = new ModificarEmpresa();
            nombre = accion.ejecutar(req, resp);
        } else if (paramAccion.equals("NuevaEmpresa")) {
            NuevaEmpresa accion = new NuevaEmpresa();
            nombre = accion.ejecutar(req, resp);
        } else if (paramAccion.equals("NuevaEmpresaForm")) {
            NuevaEmpresaForm accion = new NuevaEmpresaForm();
            nombre = accion.ejecutar(req, resp);
        }*/
    }
}
