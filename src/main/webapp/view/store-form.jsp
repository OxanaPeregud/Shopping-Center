<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Store Information Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <script src="view/validation.js"></script>
</head>

<body>
<form name="storeForm" onsubmit="return validateForm()"
      action="${pageContext.request.contextPath}/insert-store" method="post">
    <h2>Store Information</h2>

    <div class="row">
        <label>Store Name</label>
        <label>
            <input type="text" name="name">
        </label>
        <div class="error" id="nameErr"></div>
    </div>

    <div class="row">
        <label>Store Description</label>
        <label>
            <input type="text" name="description" maxlength="255">
        </label>
        <div class="error" id="descriptionErr"></div>
    </div>

    <div class="row">
        <label>Discount</label>
        <label>
            <input type="text" name="discount">
        </label>
        <div class="error" id="discountErr"></div>
    </div>

    <div class="row">
        <label>Discount Start Date</label>
        <label>
            <input type="date" name="discountStartDate" required pattern="\d{4}-\d{2}-\d{2}">
            <span class="validity"></span>
        </label>
    </div>

    <div class="row">
        <label>Discount End Date</label>
        <label>
            <input type="date" name="discountEndDate" required pattern="\d{4}-\d{2}-\d{2}">
            <span class="validity"></span>
        </label>
    </div>

    <div class="row">
        <label>Location</label>
        <label>
            <input type="text" name="location" maxlength="255">
        </label>
        <div class="error" id="locationErr"></div>
    </div>

    <div class="row">
        <label>Email Address</label>
        <label>
            <input type="text" name="email">
        </label>
        <div class="error" id="emailErr"></div>
    </div>

    <div class="row">
        <label>Mobile Number</label>
        <label>
            <input type="text" name="mobile" maxlength="12">
        </label>
        <div class="error" id="mobileErr"></div>
    </div>

    <div class="row">
        <input type="submit" value="Submit">
    </div>

</form>
</body>
</html>
