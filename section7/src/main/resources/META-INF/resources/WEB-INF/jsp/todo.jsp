<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Todo Page</title>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Enter Todos Details</h2>
    <form:form method="POST" modelAttribute="todo">
        Description: <form:input type="text" path="description" required="required" />
        <form:errors path="description" cssClass="text-warning"/>
        <form:input type="hidden" path="id" required="required" />
        <form:input type="hidden" path="done" required="required" />
        <input type="submit" class="btn btn-success">
    </form:form>

    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</div>
</body>
</html>