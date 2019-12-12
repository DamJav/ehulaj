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
    <title>e-Hulaj</title>
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
                e-Hulaj
            </h1>
            <h2 class="subtitle">
                Witaj w projekcie <strong>e-Hulaj</strong>.
                <br/>Znajdziesz tutaj ogłoszenia dotyczące elektrycznych hulajnóg.<br/>
                Aby dodać ogłoszenie musisz utworzyć konto, a następnie się zalogować.
            </h2>
            <div class="container" style="text-align: center;">
                <a class="button is-success" href="/advertisements/showAll">
                    <strong>Zobacz ogłoszenia</strong>
                </a>
            </div>

        </div>
    </div>
</section>
<jsp:include page="../media/footer.jsp"/>
<script type="text/javascript">
    alert("Twoje zgłoszenie zostało wysłane")
</script>
</body>
</html>