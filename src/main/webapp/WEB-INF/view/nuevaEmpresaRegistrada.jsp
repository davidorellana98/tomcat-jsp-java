<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
        <c:if test="${not empty empresa}">
            Empresa ${empresa} Registrada!
        </c:if>
        <c:if test="${empty empresa}">
            Ninguna empresa Registrada!
        </c:if>
    </body>
</html>