<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Nueva Empresa</title>
</head>
<body>
  <form action="${linkEntradaServlet}" method="post">
      Login: <input type="text" name="login"/>
      Contraseña: <input type="password" name="contrasena"/>
      <input type="hidden" name="accion" value="Login">
      <input type="submit"/>
  </form>
</body>
</html>