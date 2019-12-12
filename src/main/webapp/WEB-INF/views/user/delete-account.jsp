<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Usuwanie konta</title>
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
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body" style="text-align: center;">
            <h1 class="title">
                Usuwanie konta
            </h1>
            <h2 class="subtitle">
                Czy napewno chcesz usunąć konto? Tej czynności nie można cofnąć
            </h2>
            <a class="button is-primary" href="/user/deleteAccountUser">
                <strong>Tak, usuń</strong>
            </a>
            <a class="button is-primary" href="/user">
                <strong>Nie, zabierz mnie stąd!</strong>
            </a>

        </div>
    </div>
</section>
<jsp:include page="../media/footer.jsp"/>
</body>
</html>