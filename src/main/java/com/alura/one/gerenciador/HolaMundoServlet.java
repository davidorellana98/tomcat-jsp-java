package com.alura.one.gerenciador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hola")
public class HolaMundoServlet extends HttpServlet {

    String message;
    @Override
    public void init() {
        message = "Hola, haz creado tu primer servlet";
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(message);
        out.println("</body>");
        out.println("</html>");
    }
}
