<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/VR.css">

 <%@include file="/includes/head.jsp"%>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Booking Number</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>StartDate</th>
						<th>endDate</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					
				</thead>
				<tbody>
			
			
			
					<c:forEach items="${reservations}" var="reservation" >

						<tr>
							<td scope="col"><c:out value="${reservation.reservationId}"/> </td>
							<td scope="col"><c:out value="${reservation.reservationNumber}"/></td>
							<td scope="col"><c:out value="${reservation.fullName}"/></td>
							<td scope="col"><c:out value="${reservation.email}"/></td>
							<td scope="col"><c:out value="${reservation.startDate}"/></td>
							<td scope="col"><c:out value="${reservation.endDate}"/></td>
							
							<c:if test="${reservation.status eq 0}">
							<td scope="col" style="color:red">
							
							<c:out value="Not approved"/>
							
							</td>
							</c:if>
							
							<c:if test="${reservation.status eq 1}">
							<td scope="col" style="color:green">
							
							<c:out value="Approved"/>
							
							</td>
							</c:if>
							
						
							
							
							
							<td>
							<a href="viewReservations?action=edit&reservationsID=<c:out value="${reservation.reservationId}" />">View</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="?action=delete&reservationsID=<c:out value="${reservation.reservationId}" />">Cancel</a>
							
							</td>
						</tr>
						
					</c:forEach>
					
				
		
				</tbody>

			</table>
			 <%@include file="/includes/footer.jsp"%>
</body>
</html>