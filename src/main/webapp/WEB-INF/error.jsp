<%--
  Created by IntelliJ IDEA.
  User: maudg
  Date: 26/11/2020
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Error Occurred</title>
    <jsp:include page="/style.jsp"/>
</head>
<body>
<jsp:include page="/navbar.jsp"/>
<div class="h-100 container d-flex justify-content-md-center align-items-center">
    <div class="justify-content-center">
        <h3> An Error Occurred</h3>
        <br>
        <p><j:out value="${ errorMessage}"></j:out></p>
    </div>
</div>
</body>
</html>
