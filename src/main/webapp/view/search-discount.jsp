<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.searchDiscount"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/search-style.css">
</head>
<body>

<form name="searchDiscount" action="${pageContext.request.contextPath}/search-discount" method="POST">

    <div>
        <h3><fmt:message key="label.searchDiscount"/></h3>
    </div>

    <table>
        <tr>
            <td><fmt:message key="label.enterDiscount"/>:</td>
            <td>
                <label>
                    <input type="text" name="minimumDiscount"/>
                </label>
            </td>
        </tr>
    </table>

    <div>
        <input type="submit" value="<fmt:message key="label.find"/>" name="find" class="button1"/>
        <input type="reset" value="<fmt:message key="label.reset"/>" name="reset" class="button2"/>
    </div>

    <p>
        <a href="${pageContext.request.contextPath}/display-all-shops"><fmt:message key="label.allShops"/></a>
    </p>

</form>

</body>
</html>
