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
<j:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Register player</title>
    <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container h-100 d-flex justify-content-center align-items-center">

<div class="col-md-5">
    <form method="post">

        <div class="form-group">
            <label for="name">Name :</label>
            <input class="form-control" required type="text" id="name" name="name"/>
        </div>

        <div class="form-group">
            <label for="nationality">Nationality : </label>
            <input class="form-control" required type="text" id="nationality" name="nationality"/>
        </div>

        <div class="form-group">
            <label for="gender">Gender : </label>
            <select class="form-control" name="gender" id="gender">
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Register</button>

        <j:if test="${not empty result}">
            <div class="p-3 mb-2 bg-danger text-white mt-3">
                <j:out value="${ result }"></j:out>
            </div>
        </j:if>
    </form>
</div>

</body>
</html>
