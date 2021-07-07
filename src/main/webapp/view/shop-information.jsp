<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title>Full Shop Information</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/form-style.css">
</head>

<body>

<div>
    <c:if test="${shop != null}">
        <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
    </c:if>

    <div class="row">
        <label>Shop Name</label>
        <label>
            <c:out value='${shop.name}'/>
        </label>
    </div>

    <div class="row">
        <label>Shop Description</label>
        <label>
            <c:out value='${shop.description}'/>
        </label>
    </div>

    <div class="row">
        <label>Discount</label>
        <label>
            <c:out value='${shop.discount}'/>
        </label>
    </div>

    <div class="row">
        <label>Discount Start Date</label>
        <label>
            <c:out value='${shop.discountStartDate}'/>
        </label>
    </div>

    <div class="row">
        <label>Discount End Date</label>
        <label>
            <c:out value='${shop.discountEndDate}'/>
        </label>
    </div>

    <div class="row">
        <label>Location</label>
        <label>
            <c:out value='${shop.location}'/>
        </label>
    </div>

    <div class="row">
        <label>Email Address</label>
        <label>
            <c:out value='${shop.email}'/>
        </label>
    </div>

    <div class="row">
        <label>Mobile Number</label>
        <label>
            <c:out value='${shop.mobile}'/>
        </label>
    </div>

    <a href="javascript:history.back()">Go Back</a>

</div>
</body>
</html>
