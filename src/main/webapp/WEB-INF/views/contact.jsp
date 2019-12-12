<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <title>Kontakt</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">


    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="media/header.jsp"/>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body" style="text-align: center;">
            <h1 class="title">
                Kontakt
            </h1>
            <h2 class="subtitle">
                Jeżeli masz pytania, skontaktuj się z nami:
            </h2>
            <a href="https://www.facebook.com/">
                <img src="/media/fb.png" width="30px" height="30px">
            </a><hr/>
            <a href="https://www.instagram.com/">
                <img src="/media/ig.jpg" width="40px" height="40px">
            </a>
            <hr/>
            <h2 class="subtitle">
                Email: e-hulaj@wp.pl
            </h2>


        </div>
    </div>
</section>
<jsp:include page="media/footer.jsp"/>
</body>
</html>