<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>
        <c:choose>
            <c:when test="${isEdit}">
                <st:message code="editFilm"/>
            </c:when>
            <c:otherwise>
                <st:message code="addNewFilm"/>
            </c:otherwise>
        </c:choose>
    </title>
</head>
<link rel="stylesheet" href="../css/general.css">
<body>

<stf:form action="${isEdit?'/edit':'/add-film'}" method="post" modelAttribute="filmModel">
    <stf:hidden path="uuid"/>
    <div class="list">
        <div>
            <label>
                <st:message code="name"/>:
                <stf:input path="filmName" name="name" type="text"/>
                <stf:errors path="filmName"/>
            </label>
        </div>
        <div>
            <label>
                <st:message code="description"/>:
                <stf:input path="description" name="description" type="text"/>
                <stf:errors path="description"/>
            </label>
        </div>
        <div>
            <label>
                <st:message code="year"/>
                <stf:input path="year" name="year" type="number"/>
                <stf:errors path="year"/>
            </label>
        </div>
        <div>
            <label>
                <st:message code="viewed"/>:
                <stf:checkbox path="viewed" name="viewed"/>
                <stf:errors path="viewed"/>
            </label>
        </div>
    </div>
    <button type="submit">
        <c:choose>
            <c:when test="${isEdit}">
                <st:message code="editFilm"/>
            </c:when>
            <c:otherwise>
                <st:message code="addNewFilm"/>
            </c:otherwise>
        </c:choose>
    </button>

</stf:form>

<a href="/all">
    <button>
        <st:message code="allFilms"/>
    </button>
</a>

</body>
</html>
