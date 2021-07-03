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
        <a href="new-store">Add New Store</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list-stores">List of All Stores</a>
    </h2>
</div>

<div>
    <form action="list-stores" method="post">
        <table>
            <caption><h2>List of Stores</h2></caption>
            <tr>
                <th>ID</th>
                <th>Store Name</th>
                <th>Store Description</th>
                <th>Discount</th>
                <th>Discount Start Date</th>
                <th>Discount End Date</th>
                <th>Store Location</th>
                <th>Mobile</th>
                <th>Email</th>
            </tr>

            <c:forEach var="store" items="${listStores}">
                <tr>
                    <td><c:out value="${store.id}"/></td>
                    <td><c:out value="${store.name}"/></td>
                    <td><c:out value="${store.description}"/></td>
                    <td><c:out value="${store.discount}"/></td>
                    <td><c:out value="${store.discountStartDate}"/></td>
                    <td><c:out value="${store.discountEndDate}"/></td>
                    <td><c:out value="${store.location}"/></td>
                    <td><c:out value="${store.mobile}"/></td>
                    <td><c:out value="${store.email}"/></td>
                    <td>
                        <a href="edit-store?id=<c:out value='${store.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp
                        <label><input type="checkbox" name="deleteStore" value="${store.id}">Delete</label>
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
