<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <title>Shop Information Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/form-style.css">
    <script src="view/validation.js"></script>
</head>

<body>

<div>
    <c:if test="${shop != null}">
    <form name="shopForm" onsubmit="return validateForm()"
          action="${pageContext.request.contextPath}/update-shop" method="post">
        </c:if>

        <c:if test="${shop == null}">
        <form name="shopForm" onsubmit="return validateForm()"
              action="${pageContext.request.contextPath}/insert-shop" method="post">
            </c:if>

            <caption>
                <h2>
                    <a href="list-shops">List of All shops</a>
                    <br>
                    <br>
                    <c:if test="${shop != null}">
                        Edit Shop Information
                    </c:if>
                    <c:if test="${shop == null}">
                        Add New Shop Information
                    </c:if>
                </h2>
            </caption>

            <c:if test="${shop != null}">
                <input type="hidden" name="id" value="<c:out value='${shop.id}' />"/>
            </c:if>

            <div class="row">
                <label>Shop Name</label>
                <label>
                    <input type="text" name="name" maxlength="255"
                           value="<c:out value='${shop.name}' />"
                    />
                </label>
                <div class="error" id="nameErr"></div>
            </div>

            <div class="row">
                <label>Shop Description</label>
                <label>
                    <input type="text" name="description" maxlength="255"
                           value="<c:out value='${shop.description}' />"
                    />
                </label>
                <div class="error" id="descriptionErr"></div>
            </div>

            <div class="row">
                <label>Discount</label>
                <label>
                    <input type="text" name="discount" maxlength="2"
                           value="<c:out value='${shop.discount}' />"
                    />
                </label>
                <div class="error" id="discountErr"></div>
            </div>

            <div class="row">
                <label>Discount Start Date</label>
                <label>
                    <input type="date" name="discountStartDate" required pattern="\d{4}-\d{2}-\d{2}"
                           value="<c:out value='${shop.discountStartDate}' />"
                    />
                    <span class="validity"></span>
                </label>
            </div>

            <div class="row">
                <label>Discount End Date</label>
                <label>
                    <input type="date" name="discountEndDate" required pattern="\d{4}-\d{2}-\d{2}"
                           value="<c:out value='${shop.discountEndDate}' />"
                    />
                    <span class="validity"></span>
                </label>
            </div>

            <div class="row">
                <label>Location</label>
                <label>
                    <input type="text" name="location" maxlength="255"
                           value="<c:out value='${shop.location}' />"
                    />
                </label>
                <div class="error" id="locationErr"></div>
            </div>

            <div class="row">
                <label>Email Address</label>
                <label>
                    <input type="text" name="email"
                           value="<c:out value='${shop.email}' />"
                    />
                </label>
                <div class="error" id="emailErr"></div>
            </div>

            <div class="row">
                <label>Mobile Number</label>
                <label>
                    <input type="text" name="mobile" maxlength="12"
                           value="<c:out value='${shop.mobile}' />"
                    />
                </label>
                <div class="error" id="mobileErr"></div>
            </div>

            <div class="row">
                <input type="submit" value="Submit">
            </div>

        </form>
</div>
</body>
</html>
