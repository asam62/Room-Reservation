<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%
   
    Boolean authenticated = (Boolean) session.getAttribute("authenticated");

    if (authenticated == null || !authenticated) {
        response.sendRedirect("login.jsp");
    }
%>
 <%@include file="/includes/head.jsp"%>
    <title>Reservation Confirmation</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
    <h1>Reservation Confirmation</h1>
  Reservation is successful!
    <a href="ReservationServlet">Reservation details</a>
     <%@include file="/includes/footer.jsp"%>
</body>
</html>
