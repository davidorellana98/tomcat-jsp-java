package com.alura.one.gerenciador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MostrarEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println("Moodificando id: " +id);

        DB db = new DB();
        Empresa empresa = db.buscarEmpresaPorId(id);
        System.out.println(empresa.getNombre());

        req.setAttribute("empresa", empresa);
        RequestDispatcher rd = req.getRequestDispatcher("/formModificarEmpresa.jsp");
        rd.forward(req, resp);

        resp.getWriter().append("Served at...").append(req.getContextPath());
    }
}
