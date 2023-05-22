package com.alura.one.gerenciador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EliminarEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println("Eliminado id: " +id);

        DB db = new DB();
        db.elimarEmpresa(id);

        resp.sendRedirect("listaEmpresas");
    }
}
