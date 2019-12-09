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
<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="container">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="/">
                        Strona główna
                    </a>
                    <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>

                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            Więcej
                        </a>

                        <div class="navbar-dropdown">
                            <a class="navbar-item">
                                Link do niczego
                            </a>
                            <%-- Tutaj kolejne linki w menu dodatkowym --%>
                        </div>
                    </div>
                </div>

                <div class="navbar=end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <a class="button is-primary" href="/register">
                                <strong>Zarejestruj</strong>
                            </a>
                            <a class="button is-success" href="/login">
                                <strong>Zaloguj</strong>
                            </a>
                            <a class="button is-primary" href="/account">
                                <strong>Twoje konto</strong>
                            </a>
                            <form method="post" action="/logout">
                                <button class="button is-link" type="submit">Wyloguj</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                Spring Transitions
            </h1>
            <h2 class="subtitle">
                Witaj w projekcie <strong>Spring Transitions</strong>.
                <br/>Znajdziesz tutaj mnóstwo przykładów w jaki sposób mogą być wdrażane kolejne
                rozwinięcia aplikacji opartej na
                frameworku Spring i Spring Boot
            </h2>

        </div>
    </div>
</section>
<footer class="footer">
    <div class="container">
        <div class="content has-text-centered">
            <p><strong>Spring Transitions</strong> by Michał Kupisiński &copy; Prawa licencyjne na
                zasadzie praw ogólnych</p>
        </div>
    </div>
</footer>
</body>
</html>