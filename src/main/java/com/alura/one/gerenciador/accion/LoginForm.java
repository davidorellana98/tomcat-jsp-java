package com.alura.one.gerenciador.accion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginForm implements Accion {

    @Override
    public String ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "forward:formLogin.jsp";
    }
}
