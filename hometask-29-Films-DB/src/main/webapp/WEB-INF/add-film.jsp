<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 23.05.2024
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new film</title>
</head>
<link rel="stylesheet" href="css/general.css">
<body>

<form action="/add-film" method="post">
    <div class="list">
        <div>
            <label> Name :
                <input name="name" required type="text">
            </label>
        </div>
        <div>
            <label>
                Description:
                <input name="description" type="text" required>
            </label>
        </div>
        <div>
            <label>
                Year:
                <input name="year" type="number">
            </label>
        </div>
        <div>
            <label>
                Is viewed:
                <input name="viewed" type="checkbox">
            </label>
        </div>
    </div>
    <input type="submit" value="Add film">

</form>

<a href="/all"><button>Show all films</button></a>

</body>
</html>
