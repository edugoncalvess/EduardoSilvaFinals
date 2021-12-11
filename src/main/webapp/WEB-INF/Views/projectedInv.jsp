<%--
  Created by IntelliJ IDEA.
  User: edugo
  Date: 2021-12-11
  Time: 10:55 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projected Investments</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
    <h1>Projected table of customer numer ${custno}</h1>

    <h1>${custname}</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Year</th>
            <th>Starting Amount</th>
            <th>Interest</th>
            <th>Ending balance</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos1}" var="todo">



            <tr>
                <td>${todo.}</td>
                <td>${todo.itemdesc}</td>




            </tr>


        </c:forEach>
        </tbody>
    </table>




    <form method="POST">

        <input class="btn btn-back"    type="submit" value="Submit" />
    </form>

</div>
</body>
</html>
