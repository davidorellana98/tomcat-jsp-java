package com.alura.one.gerenciador.servlet;

import com.alura.one.gerenciador.modelo.DB;
import com.alura.one.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Empresa> empresas = new DB().getListaEmpresas();

        String valor = req.getHeader("Accept");
        if (valor.contains("xml")) {
            /* Libreria XML
        XStream xStream = new XStream();
        xStream.alias("empresa", Empresa.class);
        String xml = xStream.toXML(empresas);
        resp.setContentType("Application/xml");
        resp.getWriter().print(xml);*/
        } else if (valor.contains("json")) {
            /*Libreria GSON
        Gson gson = new Gson();
        String json = gson.toJson(empresas);
        resp.setContentType("Application/json");
        resp.getWriter().print(json);*/
        } else {
            resp.setContentType("Application/json");
            resp.getWriter().print("{'message':'No content'}");
        }
    }
}
