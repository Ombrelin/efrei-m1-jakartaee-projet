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
    <title>Create player</title>
</head>
<body>

<form method="post">

    <label for="name">Name :</label>
    <input type="text" id="name" name="name"/>

    <label for="nationality">Nationality : </label>
    <input type="text" id="nationality" name="nationality"/>

    <label for="gender">Gender : </label>
    <input type="text" id="gender" name="gender"/>

    <j:out value="${ result }"></j:out>
    <br/>
    <button type="submit">Create player</button>
</form>

</body>
</html>
