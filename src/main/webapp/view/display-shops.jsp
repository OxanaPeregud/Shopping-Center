<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Shopping Center</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/list-style.css">
</head>

<body>

<div>
    <h1>Shopping Center App</h1>
</div>

<div>
    <form action="display-shops" method="post">
        <table>
            <caption><h2>List of Shops</h2></caption>
            <tr>
                <th>ID</th>
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
</body>
</html>
