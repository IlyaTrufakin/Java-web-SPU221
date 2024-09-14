
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

%>

<form id="signup-form" action="<%=contextPath%>/user">

<div class="input-group mb-3">
    <span class="input-group-text" id="basic-addon1">Name</span>
    <input name="userName"  type="text" class="form-control" placeholder="Name">
</div>

<div class="input-group mb-3">
    <span class="input-group-text" id="basic-addon2">Email</span>
    <input name="userEmail"  type="text" class="form-control" placeholder="Email">
</div>

<div class="input-group mb-3">
    <span class="input-group-text" id="basic-addon3">Password</span>
    <input name="userPassword" type="text" class="form-control" placeholder="Password">
</div>
<button class="btn btn-primary">Sign-up</button>

</form>