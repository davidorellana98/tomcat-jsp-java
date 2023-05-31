package com.alura.one.gerenciador.accion;

import com.alura.one.gerenciador.modelo.DB;
import com.alura.one.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModificarEmpresa implements Accion{

    @Override
    public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombreEmpresa = req.getParameter("nombre");
        String paramFechaAbertura = req.getParameter("fecha");
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        System.out.println("Modificando Empresa " + id);

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

        return "redirect:entrada?accion=ListaEmpresas";
    }
}
