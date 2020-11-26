<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 16/11/2020
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Plan a Match</title>
    <jsp:include page="/style.jsp" />
</head>
<body>
<jsp:include page="/navbar.jsp" />
<div class="container h-100 d-flex justify-content-center align-items-center">

    <div class="col-md-5">
        <form method="post">

            <div class="form-group">
                <label for="dateTime">Date et heure du match :</label><br>
                <input class="form-control" required type="datetime-local" name="dateTime" id="dateTime"/><br>
            </div>

            <div class="form-group">
                <label for="court">Court :</label><br>
                <input class="form-control" required type="text" name="court" id="court"/>
            </div>

            <button type="submit" class="btn btn-primary">Valider</button>

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
