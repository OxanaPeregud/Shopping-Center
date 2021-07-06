<html>

<head>
    <title>Contact Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/contact-form.css">
</head>

<body>

<div class="container">
    <h3>Contact Form</h3>
    <form action="mailto:ox.peregud@gmail.com" method="POST" enctype="multipart/form-data" name="EmailForm">

        <label>First Name</label>
        <label>
            <input name="first_name" type="text" required placeholder="John"/>
        </label>
        <br>
        <label>Last Name</label>
        <label>
            <input name="last_name" type="text" required placeholder="Doe"/>
        </label>
        <br>
        <label>Email</label>
        <label>
            <input name="email" type="email" required placeholder="you@domain.com"/>
        </label>
        <br>
        <label>Message</label><br>
        <label>
            <textarea name="message" cols="30" rows="10" placeholder="Enter your message here ..." required> </textarea>
        </label>
        <div class="center">
            <input type="submit" value="Send">
        </div>
    </form>
</div>
</body>
</html>
