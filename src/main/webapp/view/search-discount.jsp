<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title>Search Discount</title>
</head>
<body>

<form name="searchDiscount" action="${pageContext.request.contextPath}/search-discount" method="POST">

    <div>
        <h3>Searching discount</h3>
    </div>

    <table>
        <tr>
            <td>Enter minimum discount:</td>
            <td>
                <label>
                    <input type="text" name="minimumDiscount"/>
                </label>
            </td>
        </tr>
        <th><input type="submit" value="Find" name="find"/></th>
        <th><input type="reset" value="Reset" name="reset"/></th>
    </table>

    <p>
        <a href="${pageContext.request.contextPath}/list-shops">Go to full Shop list</a>
    </p>

</form>

</body>
</html>
