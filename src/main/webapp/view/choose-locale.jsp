<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title>Locale</title>
</head>
<body>
<h2>
    <fmt:message key="label.chooseSessionLocale"/>
</h2>
<ul>
    <li><a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=ru"><fmt:message key="label.lang.ru"/></a></li>
</ul>
<c:if test="${not empty param.sessionLocale}">
    <fmt:message key="label.sessionChangeSuccess"/>
    <button><a href="${pageContext.request.contextPath}/map"><fmt:message key="label.startApp"/></a></button>
</c:if>

</body>
</html>
