<%--
  Created by IntelliJ IDEA.
  User: Steve Williams
  Date: 25.06.2020
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Witaj świecie</h3>
  <c:if test="${user.name eq 'Sebastian'}" >
    <p>Tutaj tylko mogą wejść Sebastiany</p>
  </c:if>

  <c:set var="userName" scope="request" value="${user.name}"/>
    ${userName}

  <c:catch var="exception">
    <c:set target="user" value="123456" property="PESEL" />
  </c:catch>
  ${exception}

  <c:choose>
    <c:when test="${user.name eq 'Sebastian'}">
      <p>Użytkownik Sebastian</p>
    </c:when>

    <c:when test="${user.name eq 'Jan'}">
      <p>Użytkownik Jan</p>
    </c:when>

    <c:otherwise>
      <p>Brak użytkownika</p>
    </c:otherwise>
  </c:choose>

  <c:forEach items="${lista}" var="us">
    ${us.id} ${us.name} ${us.lastName}
  </c:forEach>
  <br>
  <c:url value="/lista">
    <c:param name="id" value="1"/>
  </c:url>

  <p>${fn:length(lista)}</p>

  <fmt:formatNumber value="${kwota}" type="currency" currencySymbol="PLN" minFractionDigits="2" maxFractionDigits="2" />
  <fmt:formatDate value="${data}" type="both" dateStyle="short" timeStyle="long" />
  </body>
</html>
