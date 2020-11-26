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
    <jsp:include page="/style.jsp"/>
</head>
<body>
<jsp:include page="/navbar.jsp"/>
<div class="h-100 container d-flex justify-content-center align-items-center">
    <div class="col-md-5">
        <h2 class="mb-3">Login</h2>
        <form method="post">
            <div class="form-group">
                <label for="login">Login :</label>
                <input class="form-control" type="text" id="login" name="login" required/>
            </div>

            <div class="form-group">
                <label for="password">Password : </label>
                <input class="form-control" type="password" id="password" name="password" required/>
            </div>

            <button type="submit" class="btn btn-primary">Login</button>

            <j:if test="${not empty result and not result.successfull}">
                <div class="p-3 mb-2 bg-danger text-white mt-3">
                    <j:out value="${ result.message }"></j:out>
                </div>
            </j:if>
        </form>
    </div>
</div>
</body>
</html>
