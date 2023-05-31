<%@ page import="com.alura.one.gerenciador.modelo.Empresa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- JSTL: http://www.jtech.ua.es/j2ee/restringido/cw/sesion08-apuntes.html-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Java Standard Tag Library</title>
    </head>
<body>
        <c:import url="logout-parcial.jsp"></c:import>

        Usuario Logiado: ${loginUsuario.login}

        <br>
        <br>

        <c:if test="${not empty empresa}">
            Empresa ${empresa} Registrada!
        </c:if>
    Lista de Empresas: <br />

    <ul>
        <c:forEach items="${empresas}" var="empresa">
            <li>
                    ${empresa.nombre} - <fmt:formatDate value="${empresa.fechaAbertura}" pattern="dd/MM/yyyy"/>
                        <a href="/gerenciador_war_exploded/entrada?accion=MostrarEmpresa&id=${empresa.id}">modificar</a>
                        <a href="/gerenciador_war_exploded/entrada?accion=EliminarEmpresa&id=${empresa.id}">eliminar</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
