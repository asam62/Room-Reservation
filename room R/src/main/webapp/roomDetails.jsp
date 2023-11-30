<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Room Details</title>
    
    <link rel="stylesheet" href="css/roomD.css"> <!-- Include your stylesheet -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
      <%@include file="/includes/head.jsp"%>
</head>
<body>
       <%@include file="/includes/navbar.jsp"%>
    <div class="container">
        <div class="card-header my-3">Room Details</div>
<img src="uploads/${room.image}" class="img-thumbnail" width="350px" height="350px"/>
        
           
    
  
            <div class="room-item">
                <div>Room ID: <c:out value="${room.roomID}"/></div>
                <div>Room Number: <c:out value="${room.roomNumber}"/></div>
                <div>Category: 
                    <c:choose>
                        <c:when test="${room.category eq 0}">Single</c:when>
                        <c:when test="${room.category eq 1}">Double</c:when>
                        <c:when test="${room.category eq 2}">Luxury</c:when>
                        <c:when test="${room.category eq 3}">Deluxe</c:when>
                        <c:otherwise>Unknown Category</c:otherwise>
                    </c:choose>
                </div>
                <div>Capacity: <c:out value="${room.capacity}"/></div>
                <div>Description: <c:out value="${room.description}"/></div>
                <div>Status: 
                    <c:choose>
                        <c:when test="${room.status eq 0}">Room Available</c:when>
                        <c:when test="${room.status eq 1}">Room Unavailable</c:when>
                        <c:otherwise>Unknown Status</c:otherwise>
                    </c:choose>
                </div>
                
              
                <div class="form">
    <div class="card-header my-3">Room Reservation</div>
    <div class="reservation-form">
        <form action="reserve" method="post">
       
        <input type="hidden" id="status" name="status" value ="${room.status}" required>       
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="phoneNo">Phone Number:</label>
            <input type="text" id="phoneNo" name="phoneNo" required>
            
            <label for="gender">Gender:</label>
             <select class="form-control"  id="gender" name="gender" aria-label="Default select example">
            <option>Select Category</option>
            <option  selected >Select Gender</option>
            <option value="2">Male</option>
            <option value="3" >Female</option>
            
            </select>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" required>
            
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" required>
            
            <input type="hidden" name="roomID" value="${room.roomID}">
            
            <button type="submit" class="btn btn-primary">Reserve Room</button>
        </form>
    </div>
</div>
               </span>
            </div>

       
    </div>
     <%@include file="/includes/footer.jsp"%>
</body>
</html>