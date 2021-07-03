<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Shop</title>
</head>
<body>

<form name="search" action="${pageContext.request.contextPath}/search-shop" method="POST">

    <div>
        <h3>Searching shop</h3>
    </div>

    <table>
        <tr>
            <td>Enter your request:</td>
            <td>
                <label>
                    <input type="text" name="clientRequest"/>
                </label>
            </td>
        </tr>
        <th><input type="submit" value="Find" name="find"/></th>
        <th><input type="reset" value="Reset" name="reset"/></th>
    </table>

    <h2>${listShops}</h2>

    <p>
        <a href="${pageContext.request.contextPath}/list-shops">Go back to full Shop list</a>
    </p>

</form>

</body>
</html>
