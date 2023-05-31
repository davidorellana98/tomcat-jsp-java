package com.alura.one.gerenciador.accion;

import com.alura.one.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EliminarEmpresa implements Accion {

    @Override
    public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println("Eliminado id Empresa: " +id);

        DB db = new DB();
        db.elimarEmpresa(id);
        return "redirect:entrada?accion=ListaEmpresas";
    }
}
