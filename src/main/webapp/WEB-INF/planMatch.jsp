<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 16/11/2020
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Plan a Match</title>
</head>
<body>

<form method="post">
    <label for="dateTime">Date et heure du match :</label><br>
    <input type="datetime-local" name="dateTime" id="dateTime"/><br>

    <br>

    <label for="court">Court :</label><br>
    <input type="text" name="court" id="court"/><br>

    <br>

    <button type="submit">Valider</button>
</form>

</body>
</html>
