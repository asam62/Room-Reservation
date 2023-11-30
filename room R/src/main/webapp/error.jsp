<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
   
    Boolean authenticated = (Boolean) session.getAttribute("authenticated");

    if (authenticated == null || !authenticated) {
        response.sendRedirect("login.jsp");
    }
%>
 <%@include file="/includes/head.jsp"%>
<title>Error</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<h1>Error</h1>
    <p>An error occurred while processing your request.</p>
    
    <!-- Include your JavaScript dependencies if needed -->
     <%@include file="/includes/footer.jsp"%>
</body>
</html>