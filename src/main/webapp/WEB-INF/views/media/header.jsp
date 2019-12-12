<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation" style="background-color:#E3E3E3;">
        <div class="container">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="/">
                        Strona główna
                    </a>
                    <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>
                    <sec:authorize access="hasRole('USER')">
                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            Więcej
                        </a>

                        <div class="navbar-dropdown">
                            <a class="navbar-item" href="more/contact">
                                Kontakt
                            </a>
                            <a class="navbar-item" href="/problem/add">
                                Zgłoś problem
                            </a>
                            <%-- Tutaj kolejne linki w menu dodatkowym --%>
                        </div>
                    </div>
                    </sec:authorize>
                </div>

                <div class="navbar=end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <sec:authorize access="isAnonymous()">
                            <a class="button is-primary" href="/register">
                                <strong>Zarejestruj</strong>
                            </a>
                            <a class="button is-success" href="/login">
                                <strong>Zaloguj</strong>
                            </a>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ADMIN')">
                                <a class="button is-primary" href="/admin/manage">
                                    <strong>Zarządzaj</strong>
                                </a>
                                <a class="button is-primary" href="/admin/reports">
                                    <strong>Zgłoszenia</strong>
                                </a>
                            </sec:authorize>
                            <sec:authorize access="hasRole('USER')">
                                <a class="button is-primary" href="/user/advertisement/add">
                                    <strong>Dodaj ogłoszenie</strong>
                                </a>
                                <a class="button is-primary" href="/user/advertisement/show">
                                    <strong>Moje ogłoszenia</strong>
                                </a>
                                <a class="button is-primary" href="/user">

                                    <strong><sec:authentication property="name"/></strong>

                                </a></sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <form method="post" action="/logout">
                                    <button class="button is-link" type="submit">Wyloguj</button>
                                    <sec:csrfInput/>
                                </form>
                            </sec:authorize>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>