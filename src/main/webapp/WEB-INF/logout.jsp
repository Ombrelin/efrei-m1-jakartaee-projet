<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 19/11/2020
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Logged Out</title>
    <jsp:include page="/style.jsp"/>
</head>

<body>
<jsp:include page="/navbar.jsp"/>

<div class="container h-100 d-flex justify-content-center align-items-center">

    <div class="col-md-5 text-center">
        <h3>You have been logged out.</h3>
        <a class="w-25 btn btn-primary mt-4" href="<j:url value='/login'></j:url>">Log In</a>
    </div>

</div>
</body>
</html>
