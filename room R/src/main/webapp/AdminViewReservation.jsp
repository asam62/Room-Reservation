<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/room.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Admin Panel</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user">&nbsp;</span>Hello Admin</a></li>
        <li class="active"><a title="View Website" href="#"><span class="glyphicon glyphicon-globe"></span></a></li>
        <li><a href="Logout">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid">
  <div class="col-md-3">

    <div id="sidebar">
     

      <ul class="nav navbar-nav side-bar">
       <li class="side-bar tmargin"><a href="AdminPanel.jsp"><span class="glyphicon glyphicon-list">&nbsp;</span>Dashboard</a></li>
        <li class="side-bar"><a href="User"><span class="glyphicon glyphicon-user">&nbsp;</span>Users</a></li>
        <li class="side-bar"><a href="AdminViewReservation"><span class="glyphicon glyphicon-shopping-cart">&nbsp;</span>Reservations</a></li>
        <li class="side-bar"><a href="AddRooms.jsp"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add rooms</a></li>
		<li class="side-bar"><a href="addRoom"><span class="glyphicon glyphicon-eye-open">&nbsp;</span>View rooms</a></li>
     


      </ul>
    </div>
  </div>
  <div class="col-md-9 animated bounce">
  
  <!-- Admin body section -->
  
    <h1 class="page-header">View Bookings</h1>
    <ul class="breadcrumb">
      <li><span class="glyphicon glyphicon-home">&nbsp;</span>Home</li>
      <li><a href="viewReservations">View Reservations</a></li>
    </ul>
     
     <div>
       
        
        
        <table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Booking Number</th>
						<th>Full Name</th>
						<th>Mobile Number</th>
						<th>Email</th>
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
							<td scope="col"><c:out value="${reservation.phoneNo}"/></td>
							<td scope="col"><c:out value="${reservation.email}"/></td>
							
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
							<a href="viewReservations?action=edit&reservationsID=<c:out value="${reservation.reservationsID}" />&roomID=<c:out value="${reservation.roomID}" />"><span class="glyphicon glyphicon-eye-open">&nbsp;</span></a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="?action=delete&reservationsID=<c:out value="${reservation.reservationsID}" />"><span class="glyphicon glyphicon-trash">&nbsp;</span></a>
							
							</td>
						</tr>
						
					</c:forEach>
					
				
		
				</tbody>

			</table>
        
        
        
        
        
        <!-- TESTING TWO TO BE DELETED -->
        
        
        
        
        
    </div>
    
     <!-- End Admin body section -->
  </div>
</div>

</div>

 <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    
    <script type="text/javascript">
        var status = document.getElementById("status").value;
        if (status === "success") {
            swal("Room created successfully", "success");
        }
    </script>


</body>
</html>