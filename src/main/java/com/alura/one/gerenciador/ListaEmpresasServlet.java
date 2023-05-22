package com.alura.one.gerenciador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListaEmpresasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB baseDatos = new DB();
        List<Empresa> listaEmpresa = baseDatos.getListaEmpresas();

        req.setAttribute("empresas", listaEmpresa);
        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas.jsp");
        rd.forward(req, resp);
    }
}
