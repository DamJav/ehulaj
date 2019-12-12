<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
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
<section class="section">
    <div class="container" style="text-align: center;">
        <h1 class="title">
            Zaloguj się
        </h1>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form method="post" action="/login">
                    <div class="field">
                        <label class="label" for="username">Nazwa użytkownika</label>
                        <div class="control has-icons-left">
                            <input type="text" id="username" name="username" required class="input"/>
                            <span class="icon is-small is-left">
                                <i class="fas fa-user"></i>
                            </span>
                            <p class="help">Twoje imię</p>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label" for="password">Hasło</label>
                        <div class="control has-icons-left">
                            <input type="password" id="password" name="password" required class="input"/>
                            <span class="icon is-small is-left">
                                <i class="fas fa-lock"></i>
                            </span>
                            <p class="help">Twoje hasło</p>
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <button class="button is-success is-link" type="submit">Login</button>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form>
            </div>
            <div class="column"></div>
        </div>
    </div>
</section>
<jsp:include page="media/footer.jsp"/>
<c:if test="${param['error'] != null}">
    <script type="text/javascript">
        alert('Niepoprawne dane logowania')
    </script>
</c:if>
</body>
</html>