<%--
  Created by IntelliJ IDEA.
  User: maudg
  Date: 12/11/2020
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Register Referee</title>
</head>
<body>
<form method="post">

    <label for="name">Name :</label>
    <input required type="text" id="name" name="name"/>

    <label for="nationality">Nationality : </label>
    <input required type="text" id="nationality" name="nationality"/>

    <j:out value="${ result }"></j:out>
    <br/>
    <button type="submit">Register</button>
</form>
</body>
</html>
