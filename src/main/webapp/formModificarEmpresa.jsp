<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/modificarEmpresa" var="linkServerletNuevaEmpresa" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Formulario Modificar Empresa</title>
    </head>
    <body>
      <form action="${linkServerletNuevaEmpresa}" method="post">
          Nombre de la Empresa: <input type="text" name="nombre" value="${empresa.nombre}"/>
          Fecha Abertura: <input type="text" name="fecha" value="<fmt:formatDate value="${empresa.fechaAbertura}" pattern="dd/MM/yyyy"/>"/>
          <input type="hidden" name="id" value="${empresa.id}"/>
          <input type="submit"/>
      </form>
    </body>
</html>