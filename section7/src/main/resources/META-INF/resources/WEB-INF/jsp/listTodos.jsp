<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>List Todos Page</title>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Sup Wellcome ${username}</h1>
            <h2>Your Todos are:</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target</th>
                        <th>Is Done</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td>
                                <a href="update-todo?id=${todo.id}" class="btn btn-primary">Update</a>
                                <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>

            <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.3/jquery.min.js"></script>
        </div>
    </body>
</html>