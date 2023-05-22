<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/nuevaEmpresa" var="linkServerletNuevaEmpresa" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Nueva Empresa</title>
</head>
<body>
  <form action="${linkServerletNuevaEmpresa}" method="post">
      Nombre de la Empresa: <input type="text" name="nombre"/>
      Fecha Abertura: <input type="text" name="fecha"/>
    <input type="submit"/>
  </form>
</body>
</html>