<%@ include file="common/header.jspf"%>
        <div class="container">
            <%@ include file="common/navigation.jspf"%>
        </div>
        <div class="container">
            <h1>Sup Wellcome ${username}</h1>
            <h2>List Doang Dikerjain Kage</h2>
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
        </div>
<%@ include file="common/footer.jspf"%>