<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 23.05.2024
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Films</title>
</head>
<link rel="stylesheet" href="../css/general.css">
<body>
<h3>
    All films
</h3>
<div>
    <ul class="list">
        <c:forEach items="${films}" var="film">
            <li class="film">
                <c:choose>
                    <c:when test="${film.getUuid().toString().equals(editId)}">
                        <form action="/edit" method="post">
                            <div class="list edit-box">
                                <input type="hidden" name="uuid" value="${film.getUuid()}">
                                <div>
                                    <label> Name :
                                        <input name="name" required type="text" value="${film.getFilmName()}">
                                    </label>
                                </div>
                                <div>
                                    <label>
                                        Description:
                                        <input name="description" type="text" required value="${film.getDescription()}">
                                    </label>
                                </div>
                                <div>
                                    <label>
                                        Year:
                                        <input name="year" type="number" value="${film.getYear()}">
                                    </label>
                                </div>
                                <div>
                                    <label>
                                        Is viewed:
                                        <input name="viewed" type="checkbox" <c:if test="${film.isViewed()}">checked </c:if>>
                                    </label>
                                </div>
                            </div>
                            <input type="submit" value="Save editing">
                        </form>

                    </c:when>
                    <c:otherwise>
                        <div>
                            <strong>Name:</strong> ${film.getFilmName()}
                        </div>
                        <div>
                            <strong>Description:</strong> ${film.getDescription()}
                        </div>
                        <div>
                            <strong>Year:</strong> ${film.getYear()}
                        </div>
                        <div>
                            <strong>Is viewed:</strong>
                            <input type="checkbox"
                                   <c:if test="${film.isViewed()}">checked </c:if> disabled>
                        </div>
                        <a href="<c:url value='/edit?id=${film.getUuid()}' />">
                            <button>Edit Film</button>
                        </a>
                        <a href="<c:url value='/delete?id=${film.getUuid()}' />">
                            <button>Delete film</button>
                        </a>
                    </c:otherwise>
                </c:choose>
            </li>
        </c:forEach>
    </ul>

    <a href="/add-film">
        <button>Add new film</button>
    </a>
</div>
</body>
</html>
