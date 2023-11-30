<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/room.css">
<link rel="stylesheet" href="css/modal.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



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
  <input type="hidden" name="roomId" value="<c:out value="${reservation.reservationId}"/>">
  <!-- Admin body section -->
  
    <h1 class="page-header">User Hotel Booking Details</h1>
    <ul class="breadcrumb">
      <li><span class="glyphicon glyphicon-home">&nbsp;</span>Home</li>
      <li><a href="AdminViewReservation">View Reservations</a></li>
    </ul>
     
     <div>
       
        
        
        <table class="table table-bordered">
				<thead>
					<tr>
						<h3 style="color:red">
						
						Booking Details 
						 <c:choose>
			                    <c:when test="${reservation.status eq 0}">
			                        <span class="statuss">Not Approved</span>
			                    </c:when>
			                    <c:when test="${reservation.status eq 1}">
			                        <span class="statusss">Approved</span>
			                    </c:when>
			                   
			                    <c:otherwise>
			                        Unknown Status Type
			                    </c:otherwise>
			                </c:choose>
						
						
						
						
						</h3> 
						
					</tr>
				</thead>
				<tbody>
			
			
			        <tr>
			         
						<td><b>Customer Name</b> </td> <td> ${reservation.fullName} </td>
						
						<td><b>Mobile Number</b></td> <td>${reservation.phoneNo}</td>
						
			        
			        </tr>
			        
			         <tr>
			         
						<td><b>Customer Email</b> </td> <td>${reservation.email}</td>
						
						<td><b>Gender</b></td> <td>${reservation.gender}</td>
						
			        
			        </tr>
			        
			         <tr>
			         
						<td><b>Address</b></td> <td>${reservation.address}</td>
						
						<td><b>Reservation number</b></td> <td>${reservation.reservationNumber}</td>
						
			        
			        </tr>
			        
			          <tr>
			         
						<td><b>Check in Date</b></td> <td>${reservation.startDate}</td>
						
						<td><b>Check out Date</b></td> <td>${reservation.endDate}</td>
						
			        
			        </tr>
			        
			        
			        
			        
			        
			        
			        <!-- ROOM DETAILS -->
			        
					<tr>
						<td><h3 style="color:red">Room Details</h3></td>
					</tr>
				
				<tbody>
			
			
			        <tr>
			         
						<td><b>Room type</b> </td>
						
						 <td>
						 
						 <c:choose>
			                    <c:when test="${room.category eq 1}">
			                        Single Room
			                    </c:when>
			                    <c:when test="${room.category eq 2}">
			                        Double Room
			                    </c:when>
			                     <c:when test="${room.category eq 3}">
			                        Triple Room
			                    </c:when>
			                    <c:otherwise>
			                        Unknown Room Type
			                    </c:otherwise>
			                </c:choose>
						 
						 
						 
						
						
						</td>
						
						<td><b>Room Number</b></td> <td>${room.roomNumber}</td>
						
			        
			        </tr>
			        
			         <tr>
			         
						<td><b>Room Status </b></td> 
						
						<td>
						
						<c:choose>
			                    <c:when test="${room.status eq 0}">
			                        Not Checked In
			                    </c:when>
			                    <c:when test="${room.category eq 1}">
			                        Checked In
			                    </c:when>
			                     <c:when test="${room.category eq 2}">
			                        Checked out
			                    </c:when>
			                    <c:otherwise>
			                        Unknown Status Type
			                    </c:otherwise>
			                </c:choose>
						 
						
						
						</td>
						
						<td><b>Capacity</b></td> <td>${room.capacity}</td>
						
			        
			        </tr>
			        
			         <tr>
			         
						<td><b>Description</b></td> <td>${room.description}</td>
						
						<td>Image</td> <td><img src="uploads/${room.image}" class="img-thumbnail" width="150px" height="150px"/></td>
						
			        
			        </tr>
			        
			          <tr>
			         
						<td></td> 
						
						<td> 
						<c:choose>
			                    <c:when test="${reservation.status eq 0}">
			                 <button id="openModalBtn">Approve</button>
			                    </c:when>
			                    <c:when test="${reservation.status eq 1}">
			                        <button class="btn btn-danger" id="openModalBtn2">Disapprove</button>
			                    </c:when>
			                    
			                    <c:otherwise>
			                        Unknown Status Type
			                    </c:otherwise>
			                </c:choose>
						
						
							
							</td>
						
						<td></td>
						
			        
			        </tr>
			        
			        
			        
			        
			        
			        
			        
			        
			        
				
		
				</tbody>

			</table>
        
         
</div>
    
        <!-- Button trigger modal -->




<div id="myModal" class="modal">
    <div class="modal-content">
    <form method="post" action="UpdateStatus">
        <span class="close">&times;</span>
        <h2 class="confirm-h">Approve Booking</h2>
        <p class="affirm">Are you sure you want to approve booking?</p>
        <button type="submit">Approve</button>
        
        </form>
    </div>
</div>

<div id="myModal2" class="modal2">
    <div class="modal-content2">
    <form method="post" action="Disapprove">
        <span class="close2">&times;</span>
        <h2 class="confirm-h">Disapprove Booking</h2>
        <p class="affirm">Are you sure you want to disapprove booking?</p>
        
        <button class="btn btn-danger" type="submit">Disapprove</button>
        
        </form>
    </div>
</div>
        
        <!-- TESTING TWO TO BE DELETED -->
        
        
        
        
        
    </div>
    
     <!-- End Admin body section -->
  </div>
</div>

</div>


 
    
   
  
<script >

//Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById('openModalBtn');

// Get the <span> element that closes the modal
var span = document.getElementsByClassName('close')[0];

// When the user clicks on the button, open the modal
btn.onclick = function () {
    modal.style.display = 'block';
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = 'none';
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = 'none';
    }
}

</script>

  
<script >

//Get the modal
var modal2 = document.getElementById('myModal2');

// Get the button that opens the modal
var btn2 = document.getElementById('openModalBtn2');

// Get the <span> element that closes the modal
var span2 = document.getElementsByClassName('close2')[0];

// When the user clicks on the button, open the modal
btn2.onclick = function () {
    modal2.style.display = 'block';
}

// When the user clicks on <span> (x), close the modal
span2.onclick = function () {
    modal2.style.display = 'none';
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal2) {
        modal2.style.display = 'none';
    }
}

</script>

</body>
</html>