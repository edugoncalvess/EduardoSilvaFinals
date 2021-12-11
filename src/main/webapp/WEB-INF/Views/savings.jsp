<%--
  Created by IntelliJ IDEA.
  User: edugo
  Date: 2021-12-11
  Time: 9:38 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Savings</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            background-color: cyan;
        }

        .btn {
            width: 100%;
        }


    </style>
</head>
<body>
<h1>Savings Investment Records</h1>
<script>
    document.getElementById("mes").innerHTML = "";
</script>



    <h1 id="mes">${errorMessage}</h1>
    <div class="container2">
        <h2>The following are the savings records</h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Customer number</th>
                <th>Customer Name</th>
                <th>Customer Deposit</th>
                <th>Number of years</th>
                <th>Savings Type</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">



                <tr>


                    <td>${todo.custno}</td>
                    <td>${todo.custname}</td>
                    <td>${todo.cdep}</td>
                    <td>${todo.nyears}</td>
                    <td>${todo.savtype}</td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.custno}" >Edit</a> </td>


                    <!-- The href is changed after the alert message is shown -->
                    <!-- the link for the method called is on the javascript-->
                    <td>    <a type="button" class="btn btn-primary" id="deleteBtn" onclick="confirmDelete()"
                               href="" >Delete</a> </td>



                    <td>    <a type="button" class="btn btn-primary"
                               href="see-todo?id=${todo.custno}" >Projected Investment</a> </td>


                </tr>


            </c:forEach>
            </tbody>
        </table>
    </div>

        <a class="btn btn-success" onmouseout="myFunction()"  href="add-todo">Add</a>
</div>


<script>

    function myFunction() {

        document.getElementById("mes").innerHTML = "";
    }

    function confirmDelete() {
        var link = document.getElementById("deleteBtn");
        link.setAttribute("href", "delete-todo?id=${todo.custno}");
        return false;
    }

</script>



</body>
</html>
