<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:forEach var="i" begin="1" end="10" step="2">
          ${i} <br />
        </c:forEach>
    </body>
</html>
