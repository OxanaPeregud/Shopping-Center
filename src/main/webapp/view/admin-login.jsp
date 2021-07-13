<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="POST">

    Name:
    <label>
        <input type="text" name="name" required>
    </label>
    <br>

    Password:
    <label>
        <input type="password" name="password" required>
    </label>
    <br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
