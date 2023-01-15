<html>
    <head>
        <title>Login Page</title>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Login</h2>
            <pre>${errorMessage}</pre>
            <form method="POST">
                <a>Name: <input type="text" name="name"></a>
                <a>Password: <input type="password" name="password"></a>
                <input type="submit">
            </form>
        </div>
        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.3/jquery.min.js"></script>
    </body>
</html>