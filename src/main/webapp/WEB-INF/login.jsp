<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 12/11/2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form method="post">

    <label for="login">Login :</label>
    <input type="text" id="login" name="login"/>

    <label for="password">Password : </label>
    <input type="password" id="password" name="password"/>

    <j:out value="${ result }"></j:out>
    <br/>
    <button type="submit">Login</button>
</form>

</body>
</html>
