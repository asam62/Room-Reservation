<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   
 <%@include file="/includes/head.jsp"%>
   <%
   
    Boolean authenticated = (Boolean) session.getAttribute("authenticated");

    if (authenticated == null || !authenticated) {
        response.sendRedirect("login.jsp");
    }
%>
    <title>Goodbye</title>
</head>
<body>

<%@include file="/includes/navbar.jsp"%>
    <h1>Goodbye!</h1>
    <p>You have been successfully logged out.</p>
    <a href="login.jsp">Log In Again</a>
     <%@include file="/includes/footer.jsp"%>
</body>
</html>
