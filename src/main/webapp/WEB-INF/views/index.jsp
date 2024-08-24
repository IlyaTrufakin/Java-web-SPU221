
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String contextPath = request.getContextPath();  //~
    String fromServlet = (String) request.getAttribute("fromServlet");
%>


<h1>JSP</h1>
<p>Java server pages - технологія створення вебзастосунків на Java</p>
<a href="<%= contextPath %>/hello.jsp">Hello world</a>
<p>
    fromServlet = <%=fromServlet%>
</p>

<%
    // блок коду за синтаксісом Java
    int x = 10;
    double y = 56.6;
    int[] arr = {1, 2, 3, 4};
%>
<p>x = <%= x %>
</p>
<p>y = <%= y %>
</p>
<% for (int a : arr) { %>
<span> element = <%= a %> </span> &emsp;
<%} %>