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
        <h2 class="mb-3">Plan a Match</h2>
        <form method="post">

            <div class="form-group">
                <label for="dateTime">Match date and Time :</label><br>
                <input class="form-control" required type="datetime-local" name="dateTime" id="dateTime"/><br>
            </div>

            <div class="form-group">

                <div class="row m-0 mb-2 justify-content-between">
                    <label for="court">Court : </label>
                    <a href="<j:url value='/admin/registerCourt'></j:url>" class="btn btn-success"><i class="fas fa-plus"></i></a>
                </div>
                <select class="form-control" name="court" id="court">
                    <j:forEach items="${ courts }" var="court">
                        <option value="<j:out value='${court.id}'></j:out>"><j:out value='${court.number}'></j:out></option>
                    </j:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>

            <j:if test="${not empty result}">
                <div class="p-3 mb-2 ${result.successfull ? "bg-success" : "bg-danger"} text-white mt-3">
                    <j:out value="${ result.message }"></j:out>
                </div>
            </j:if>
        </form>
    </div>
</div>
</body>
</html>
