package com.alura.one.gerenciador.accion;

import com.alura.one.gerenciador.modelo.DB;
import com.alura.one.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Accion {

    @Override
    public String  ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long antes = System.currentTimeMillis();

        System.out.println("Listando empresas");
        DB baseDatos = new DB();
        List<Empresa> listaEmpresa = baseDatos.getListaEmpresas();

        req.setAttribute("empresas", listaEmpresa);

        long despues = System.currentTimeMillis();
        System.out.println("Timepo de ejecucion: " + (despues - antes));

        return "forward:listaEmpresas.jsp";
    }
}
