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
    <h2>
        <a href="new-shop">Add New Shop</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list-shops">List of All Shops</a>
        &nbsp;&nbsp;&nbsp;
        <a href="view/search-shop.jsp">Search Shop</a>
        &nbsp;&nbsp;&nbsp;
        <a href="view/search-discount.jsp">Search Discount</a>
    </h2>
</div>

<div>
    <form action="list-shops" method="post">
        <table>
            <caption><h2>List of Shops</h2></caption>
            <tr>
                <th>ID</th>
                <th>Shop Name</th>
                <th>Shop Description</th>
                <th>Discount</th>
                <th>Discount Start Date</th>
                <th>Discount End Date</th>
                <th>Shop Location</th>
                <th>Mobile</th>
                <th>Email</th>
            </tr>

            <c:forEach var="shop" items="${listShops}">
                <tr>
                    <td><c:out value="${shop.id}"/></td>
                    <td><c:out value="${shop.name}"/></td>
                    <td><c:out value="${shop.description}"/></td>
                    <td><c:out value="${shop.discount}"/></td>
                    <td><c:out value="${shop.discountStartDate}"/></td>
                    <td><c:out value="${shop.discountEndDate}"/></td>
                    <td><c:out value="${shop.location}"/></td>
                    <td><c:out value="${shop.mobile}"/></td>
                    <td><c:out value="${shop.email}"/></td>
                    <td>
                        <a href="edit-shop?id=<c:out value='${shop.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp
                        <label><input type="checkbox" name="deleteShop" value="${shop.id}">Delete</label>
                    </td>
                </tr>
            </c:forEach>

            <tr class="right">
                <td>
                    <input type="submit" value="Submit"/>
                </td>
            </tr>

        </table>
    </form>

</div>
</body>
</html>
