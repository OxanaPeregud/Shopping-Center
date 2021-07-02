<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Application Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <script src="view/validation.js"></script>
</head>

<body>
<form name="storeForm" onsubmit="return validateForm()"
      action="${pageContext.request.contextPath}/insert-store" method="post">
    <h2>Store information</h2>

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
            <input type="text" name="description">
        </label>
        <div class="error" id="descriptionErr"></div>
    </div>

    <div class="row">
        <label>Discount</label>
        <label>
            <input type="text" name="discount">
        </label>
    </div>

    <div class="row">
        <label>Discount Start Date</label>
        <label>
            <input type="date" name="discountStartDate">
        </label>
    </div>

    <div class="row">
        <label>Discount End Date</label>
        <label>
            <input type="date" name="discountEndDate">
        </label>
    </div>

    <div class="row">
        <label>Location</label>
        <label>
            <input type="text" name="location">
        </label>
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
