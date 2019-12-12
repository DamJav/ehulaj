<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2019-12-09
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html>
<head>
    <title>Zgłoszenia</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">


    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="../media/header.jsp"/>

<div class="container" style="background: rgb(218,218,218);
background: linear-gradient(90deg, rgba(218,218,218,1) 0%, rgba(247,247,247,1) 46%, rgba(218,218,218,0.8687850140056023) 100%);
 width:70%; text-align: center; padding: 15px;">
    <table>
        <h1 class="title">Wszystkie zgłoszenia</h1>
                <for:forEach items="${problems}" var="problem">
                    <tr>
                        <td> Data zgłoszenia  <br/>
                        <td>  Temat: <br/>
                        <td> Opis: </td>
                        <td> Zgłaszający:</td>
                        <td> Status:</td>
                        <td> Akcje:</td>
                    </tr>
                    <tr>
                        <td>${problem.reported}</td>

                        <td><b>${problem.subject}</b></td>
                        <td>${problem.description}</td>
                        <td> ${problem.user.email} <br/>
                        <td> ${problem.status} <br/>
                        <c:url value="/admin/reports/end" var="endURL">
                            <c:param name="id" value="${problem.id}"/>
                        </c:url>
                        <td> <a href="${endURL}">Zakończ</a></td>

                    </tr>
                    <br/>
                </for:forEach>
            </table>
    </div>

<jsp:include page="../media/footer.jsp"/>
</body>
</html>