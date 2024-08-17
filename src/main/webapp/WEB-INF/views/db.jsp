<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String) request.getAttribute("error");
    List<?> databases = (List<?>) request.getAttribute("dataBases");
%>

<h1> Робота с БД </h1>
<ul>
    <li>Встановлюємо СУБД </li>
    <li>Створюємо СУБД </li>
    <li>Додаємо залежність до дравера БД (конектора, mysql-connector-j ) </li>

</ul>

<% if(error == null) {%>
        <p>Робота з БД успішна</p>
<% } else { %>
<b>Виникла помилка <%= error%> </b>
 <%   } %>


<% if(databases == null) {%>
<p>Дані не передані</p>
<% } else { for (Object str : databases) {%>
<p> <%= str.toString()%> </p>
<%   } }%>
