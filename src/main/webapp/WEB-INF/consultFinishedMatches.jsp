<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Consult finished matches</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Team 1 Score</th>
                <th>Team 2 Score</th>
                <th>Date</th>
                <th>Court</th>
            </tr>
        </thead>
        <j:forEach items="${result}" var="match">
            <tr>
                <td>${match.id}</td>
                <td>${match.team1Score}</td>
                <td>${match.team2Score}</td>
                <td>${match.dateTime}</td>
                <td>${match.court}</td>
            </tr>
        </j:forEach>
    </table>


</body>
</html>
