<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2019-12-10
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zgłoś problem</title>
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

<section class="section">
    <div class="container" style="text-align:center;">
        <h1 class="title">
            Problem
        </h1>
        <h2 class="subtitle">
            Wypełnij formularz danymi
        </h2>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form method="post" modelAttribute="problemData">
                    <div class="field">
                    <form:label path="description" cssClass="label">Temat problemu</form:label>
                    <form:select path="subject">
                    <form:option value="Problem ze stroną"/>
                    <form:option value="Propozycja rozwoju"/>
                    <form:option value="Inny temat"/>
                    </form:select>
                    </div>
                    <div class="field">
                        <form:label path="description" cssClass="label">Opis</form:label>
                        <form:textarea style="margin: 0px; width: 450px; height: 100px;" placeholder ="Max 1000 znaków" path="description" cssClass="input" required="true"
                        ></form:textarea>
                        <p class="help">Opis problemu</p>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-success is-link" type="submit">Zgłoś
                            </button>
                        </div>
                        <div class="control">
                            <button class="button is-text" type="reset">Reset</button>
                        </div>
                    </div>
                    <form:errors path="*"/>
                    <sec:csrfInput/>
                </form:form>
            </div>
            <div class="column">
            </div>
        </div>
    </div>
</section>
<jsp:include page="../media/footer.jsp"/>
</body>
</html>