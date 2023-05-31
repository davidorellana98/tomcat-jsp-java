package com.alura.one.gerenciador.accion;

import com.alura.one.gerenciador.modelo.DB;
import com.alura.one.gerenciador.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Login implements Accion {

    @Override
    public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramLogin = req.getParameter("login");
        String paramContrasena = req.getParameter("contrasena");

        DB db = new DB();
        Usuario usuario = db.existeUsuario(paramLogin, paramContrasena);

        if (usuario != null) {
            System.out.println("Usuario existe!");
            HttpSession session = req.getSession();
            session.setAttribute("loginUsuario", usuario);
            return "redirect:entrada?accion=ListaEmpresas";
        } else {
            return "redirect:entrada?accion=LoginForm";
        }
    }
}
