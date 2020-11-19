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
    <jsp:include page="/style.jsp" />
</head>
<body>
<jsp:include page="/navbar.jsp" />

You have been logged out. <a href="<j:url value='/login'></j:url>">Log In</a>

</body>
</html>
