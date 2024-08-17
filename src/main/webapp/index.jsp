
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String contextPath = request.getContextPath();  //~
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- comment -->
<h1>JSP</h1>
<p>Java server pages - технологія створення вебзастосунків на Java</p>
<a href="<%= contextPath %>/hello.jsp">Hello world</a>
<%
    // блок коду за синтаксісом Java
    int x = 10;
    double y = 56.6;
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
%>
<p>x = <%= x %>
</p>
<p>y = <%= y %>
</p>
<% for (int a : arr) { %>
<span> element = <%= a %> </span> &emsp;
<%} %>
}
</body>
</html>
