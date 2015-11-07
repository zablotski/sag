<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<p>
    <c:if test="${errorMessage == null}">
        <c:out value="Hello ${firstName}"/>
    </c:if>
    <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"/>
    </c:if>
</p>
</body>
</html>