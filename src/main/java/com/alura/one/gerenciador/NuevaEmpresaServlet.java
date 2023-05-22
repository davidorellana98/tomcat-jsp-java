package com.alura.one.gerenciador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NuevaEmpresaServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Nueva empresa registrada");
        String nombreEmpresa = req.getParameter("nombre");
        String paramFechaAbertura = req.getParameter("fecha");

        Date fechaAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            fechaAbertura = sdf.parse(paramFechaAbertura);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNombre(nombreEmpresa);
        empresa.setFechaAbertura(fechaAbertura);

        DB baseDatos =  new DB();
        baseDatos.agregarEmpresa(empresa);

        resp.sendRedirect("listaEmpresas");

        //llamando a JSP
//        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//        req.setAttribute("empresa", empresa.getNombre());
//        rd.forward(req, resp);
    }
}
