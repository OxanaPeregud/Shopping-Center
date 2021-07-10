<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="label.mall"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/table.css">
</head>

<body>

<button type="button" class="button"><a class="homepage" href="map"><fmt:message key="label.back"/></a></button>

<div>
    <h1><fmt:message key="label.app"/></h1>
</div>

<div>
    <h2>
        <a href="view/search-shop.jsp"><fmt:message key="label.searchShop"/></a>
        &nbsp;&nbsp;&nbsp;
        <a href="display-all-shops"><fmt:message key="label.allShops"/></a>
        &nbsp;&nbsp;&nbsp;
        <a href="display-all-discounts"><fmt:message key="label.allDiscounts"/></a>
    </h2>
</div>

<div>

    <table id="customers">
        <caption><h2><fmt:message key="label.discounts"/></h2></caption>
        <tr>
            <th><fmt:message key="label.discount"/></th>
            <th><fmt:message key="label.discountStartDate"/></th>
            <th><fmt:message key="label.discountEndDate"/></th>
        </tr>

        <c:forEach var="discount" items="${listDiscountShops}">
            <tr>
                <td><c:out value="${discount.discount}"/></td>
                <td><c:out value="${discount.discountStartDate}"/></td>
                <td><c:out value="${discount.discountEndDate}"/></td>
            </tr>

        </c:forEach>
    </table>
</div>

<footer>
    <a href="admin-login"><fmt:message key="label.dbAccess"/></a>
</footer>

</body>
</html>
