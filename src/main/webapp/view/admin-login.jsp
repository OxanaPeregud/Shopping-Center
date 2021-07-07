<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

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
