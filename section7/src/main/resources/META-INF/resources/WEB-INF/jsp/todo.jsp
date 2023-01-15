<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Todo Page</title>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Enter Todos Details</h2>
    <form method="POST">
        Description: <input type="text" name="description" />
        <input type="submit" class="btn btn-success">
    </form>

    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</div>
</body>
</html>