package com.alura.one.gerenciador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModificarEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Modificando Empresa");

        String nombreEmpresa = req.getParameter("nombre");
        String paramFechaAbertura = req.getParameter("fecha");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println(id);

        Date fechaAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            fechaAbertura = sdf.parse(paramFechaAbertura);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        DB db = new DB();
        Empresa empresa = db.buscarEmpresaPorId(id);
        empresa.setNombre(nombreEmpresa);
        empresa.setFechaAbertura(fechaAbertura);

        resp.sendRedirect("listaEmpresas");
    }
}
