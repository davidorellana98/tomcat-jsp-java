package com.alura.one.gerenciador.accion;

import com.alura.one.gerenciador.modelo.DB;
import com.alura.one.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NuevaEmpresa implements Accion {

    @Override
    public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        req.setAttribute("empresa", empresa.getNombre());
        return "redirect:entrada?accion=ListaEmpresas";
    }
}
