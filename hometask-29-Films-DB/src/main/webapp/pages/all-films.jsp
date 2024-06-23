<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="stf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mes" uri="http://www.springframework.org/tags" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="st" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><mes:message code="allFilmsTitle"/>
    </title>
</head>
<link rel="stylesheet" href="../css/general.css">
<body>
<h3>
    <mes:message code="allFilmsTitle"/>
</h3>
<div>
    <ul class="list">
        <c:forEach items="${films}" var="film">
            <li class="film">
                <div>
                    <strong><mes:message code="name"/> :</strong> ${film.getFilmName()}
                </div>
                <div>
                    <strong><mes:message code="description"/> :</strong> ${film.getDescription()}
                </div>
                <div>
                    <strong><mes:message code="year"/> :</strong> ${film.getYear()}
                </div>
                <div>
                    <strong><mes:message code="viewed"/> :</strong>
                    <input type="checkbox"
                           <c:if test="${film.isViewed()}">checked </c:if> disabled>
                </div>
                <a href="<c:url value='/add-film?id=${film.getUuid()}' />">
                    <button><mes:message code="editFilm"/></button>
                </a>
                <a href="<c:url value='/delete?id=${film.getUuid()}' />">
                    <button><mes:message code="deleteFilm"/></button>
                </a>
            </li>
        </c:forEach>
    </ul>

    <a href="/add-film">
        <button><mes:message code="addNewFilm"/></button>
    </a>

    <hr>

    <div style="display: flex; justify-content: center; gap: 20px">
        <a href="${pageContext.request.contextPath}/all?lang=en">
            <button>En</button>
        </a>
        <a href="${pageContext.request.contextPath}/all?lang=ru">
            <button>Ru</button>
        </a>
    </div>

</div>
</body>
</html>
