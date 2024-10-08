
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String contextPath =  request.getContextPath();
    String pageBody = (String) request.getAttribute("pageBody");
    if(pageBody == null) {
        pageBody = "hello.jsp";
    }
%>

<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=contextPath%>/img/favicon.ico" type="image/x-icon">
    <title>Java web</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=contextPath%>/css/site.css">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">

        <div class="container-fluid">

            <a class="navbar-brand" href="#">
                <img src="<%=contextPath%>/img/images.png" alt="logo"  class="d-inline-block align-text-top">
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">

                <span class="navbar-toggler-icon"></span>

            </button>

            <div class="collapse navbar-collapse" id="navbarNav">

                <ul class="navbar-nav">

                    <li class="nav-item">

                        <a class="nav-link active" aria-current="page" href="<%=contextPath%>">Home</a>

                    </li>

                    <li class="nav-item">

                        <a class="nav-link" href="<%=contextPath%>/db">DB</a>

                    </li>

                    <li class="nav-item">

                        <a class="nav-link" href="#">Pricing</a>

                    </li>

                    <li class="nav-item">

                        <a class="nav-link disabled" aria-disabled="true">Disabled</a>

                    </li>

                </ul>

            </div>

        </div>

    </nav>
</header>

<main class="container">
    <jsp:include page="<%= pageBody %>" />
 </main>

<div class="spacer"></div>

    <footer>Footer</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="<%=contextPath%>/js/site.js"> </script>


</body>


</html>
