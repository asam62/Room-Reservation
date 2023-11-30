<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminPanelBody.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css">

<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/room.css">



<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
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
        <li class="side-bar"><a href="ReservationServlet"><span class="glyphicon glyphicon-shopping-cart">&nbsp;</span>Reservations</a></li>
        <li class="side-bar"><a href="AddRooms.jsp"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add rooms</a></li>
		<li class="side-bar"><a href="addRoom"><span class="glyphicon glyphicon-eye-open">&nbsp;</span>View rooms</a></li>
     


      </ul>
    </div>
  </div>
  <div class="col-md-9 animated bounce">
  
  <!-- Admin body section -->
  
    <h1 class="page-header">Add Rooms</h1>
    <ul class="breadcrumb">
      <li><span class="glyphicon glyphicon-home">&nbsp;</span>Home</li>
      <li><a href="#">Rooms</a></li>
    </ul>
     
     <div>
         <h1>Upload Hotel Room Details</h1>
        <form method="post" action="addRoom"  enctype="multipart/form-data">
        
        <input type="hidden" name="roomID" value="<c:out value="${room.roomID}"/>">
        
            <label for="roomNumber">Room Number:</label>
            <input type="text" id="roomNumberId" name="roomNumber"  required  value="<c:out value="${room.roomNumber}"/>"><br>

            <label for="category">Category:</label>
           <!--  <input type="text" id="categoryId" name="category" value="<c:out value="${room.category}"/>" required> --> <br>
            
            <select class="form-control"  id="categoryId" name="category" aria-label="Default select example">
            <option>Select Category</option>
            <option value="1" <c:if test="${room.category == 1}"> selected</c:if>>Single Room</option>
            <option value="2" <c:if test="${room.category == 2}"> selected</c:if>>Double Room</option>
            <option value="3" <c:if test="${room.category == 3}"> selected</c:if>>Luxury Room</option>
            <option value="4" <c:if test="${room.category == 4}"> selected</c:if>>Deluxe Room</option>
            
            </select>

            <label for="capacity">Capacity:</label>
            <input type="text" id="capacityId" name="capacity" value="<c:out value="${room.capacity}"/>" required><br>
            
             <label for="description">Description:</label>
            <textarea id="descriptionId" name="description" placeholder ="<c:out value="${room.description}"/>" required></textarea>

            <label for="image">Room Image:</label>
            <input type="file" id="imageId" name="image" accept="image/*" required><br>
            
            <c:if test="${room.image != null}">
            
            <img src="uploads/${room.image}" class="img-thumbnail" width="150px" height="150px"/>
            </c:if>

            <button type="submit">Submit</button>
            
            <br/>
            </form>
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