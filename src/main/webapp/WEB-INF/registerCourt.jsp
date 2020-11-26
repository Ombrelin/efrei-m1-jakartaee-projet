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
    <title>Register Court</title>
    <jsp:include page="/style.jsp"/>
</head>
<body>
<jsp:include page="/navbar.jsp"/>
<div class="container h-100 d-flex justify-content-center align-items-center">
    <div class="col-md-5">
        <h2 class="mb-3">Register New Court</h2>
        <form method="post">

            <div class="form-group">
                <label for="number">Number :</label>
                <input class="form-control" required type="text" id="number" name="number"/>
            </div>

            <button type="submit" class="btn btn-primary">Register</button>

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
