<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <title>Store Information Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/form-style.css">
    <script src="view/validation.js"></script>
</head>

<body>

<div>
    <c:if test="${store != null}">
    <form name="storeForm" onsubmit="return validateForm()"
          action="${pageContext.request.contextPath}/update-store" method="post">
        </c:if>

        <c:if test="${store == null}">
        <form name="storeForm" onsubmit="return validateForm()"
              action="${pageContext.request.contextPath}/insert-store" method="post">
            </c:if>

            <caption>
                <h2>
                    <a href="list-stores">List of All Stores</a>
                    <br>
                    <br>
                    <c:if test="${store != null}">
                        Edit Store Information
                    </c:if>
                    <c:if test="${store == null}">
                        Add New Store Information
                    </c:if>
                </h2>
            </caption>

            <c:if test="${store != null}">
                <input type="hidden" name="id" value="<c:out value='${store.id}' />"/>
            </c:if>

            <div class="row">
                <label>Store Name</label>
                <label>
                    <input type="text" name="name" maxlength="255"
                           value="<c:out value='${store.name}' />"
                    />
                </label>
                <div class="error" id="nameErr"></div>
            </div>

            <div class="row">
                <label>Store Description</label>
                <label>
                    <input type="text" name="description" maxlength="255"
                           value="<c:out value='${store.description}' />"
                    />
                </label>
                <div class="error" id="descriptionErr"></div>
            </div>

            <div class="row">
                <label>Discount</label>
                <label>
                    <input type="text" name="discount" maxlength="2"
                           value="<c:out value='${store.discount}' />"
                    />
                </label>
                <div class="error" id="discountErr"></div>
            </div>

            <div class="row">
                <label>Discount Start Date</label>
                <label>
                    <input type="date" name="discountStartDate" required pattern="\d{4}-\d{2}-\d{2}"
                           value="<c:out value='${store.discountStartDate}' />"
                    />
                    <span class="validity"></span>
                </label>
            </div>

            <div class="row">
                <label>Discount End Date</label>
                <label>
                    <input type="date" name="discountEndDate" required pattern="\d{4}-\d{2}-\d{2}"
                           value="<c:out value='${store.discountEndDate}' />"
                    />
                    <span class="validity"></span>
                </label>
            </div>

            <div class="row">
                <label>Location</label>
                <label>
                    <input type="text" name="location" maxlength="255"
                           value="<c:out value='${store.location}' />"
                    />
                </label>
                <div class="error" id="locationErr"></div>
            </div>

            <div class="row">
                <label>Email Address</label>
                <label>
                    <input type="text" name="email"
                           value="<c:out value='${store.email}' />"
                    />
                </label>
                <div class="error" id="emailErr"></div>
            </div>

            <div class="row">
                <label>Mobile Number</label>
                <label>
                    <input type="text" name="mobile" maxlength="12"
                           value="<c:out value='${store.mobile}' />"
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
