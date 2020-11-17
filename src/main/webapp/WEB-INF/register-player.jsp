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
    <title>Register player</title>
</head>
<body>

<form method="post">

    <label for="name">Name :</label>
    <input required type="text" id="name" name="name"/>

    <label for="nationality">Nationality : </label>
    <input required type="text" id="nationality" name="nationality"/>

    <label for="gender">Gender : </label>
    <select name="gender" id="gender">
        <option value="MALE">Male</option>
        <option value="FEMALE">Female</option>
    </select>

    <j:out value="${ result }"></j:out>
    <br/>
    <button type="submit">Register player</button>
</form>

</body>
</html>
