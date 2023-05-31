package com.alura.one.gerenciador.accion;

import com.alura.one.gerenciador.modelo.DB;
import com.alura.one.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MostrarEmpresa implements Accion {

    @Override
    public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println("Mostrando empresa con id: " +id);

        DB db = new DB();
        Empresa empresa = db.buscarEmpresaPorId(id);
        System.out.println(empresa.getNombre());

        req.setAttribute("empresa", empresa);
        return "forward:formModificarEmpresa.jsp";
    }
}
