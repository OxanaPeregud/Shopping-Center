<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title>Shopping Center</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/list-style.css">
</head>

<body>

<div>
    <h1>Shopping Center App</h1>
</div>

<div>
    <h1><fmt:message key="label.app"/></h1>
    <h2>
        <a href="view/search-shop.jsp"><fmt:message key="label.searchShop"/></a>
        &nbsp;&nbsp;&nbsp;
        <a href="view/search-discount.jsp"><fmt:message key="label.searchDiscount"/></a>
        &nbsp;&nbsp;&nbsp;
        <a href="display-searched-shops"><fmt:message key="label.searchActualDiscount"/></a>
    </h2>
</div>

<div>
    <form action="display-searched-shops" method="post">
        <table>
            <caption><h2>List of Shops</h2></caption>
            <tr>
                <th>Shop Name</th>
                <th>Discount</th>
                <th>Shop Location</th>
            </tr>

            <c:forEach var="shop" items="${listShops}">
                <tr>
                    <c:if test="${shop != null}">
                        <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
                    </c:if>
                    <td><c:out value="${shop.name}"/></td>
                    <td><c:out value="${shop.discount}"/></td>
                    <td><c:out value="${shop.location}"/></td>
                    <td>
                        <a href="info-shop?id=<c:out value='${shop.id}' />">Show full Information About the Shop</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </form>

</div>

<footer>
    <a href="admin-login">Access database information</a>
</footer>

</body>
</html>
