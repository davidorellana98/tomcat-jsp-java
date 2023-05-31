package com.alura.one.gerenciador.accion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Logout implements Accion {
    @Override
    public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        //session.removeAttribute("loginUsuario");
        session.invalidate();
        return "redirect:entrada?accion=LoginForm";
    }
}
