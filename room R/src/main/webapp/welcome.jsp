<%@page import="Dao.Dbonnect"%>
<%@page import="Dao.RoomDao"%>
<%@page import="Model.User"%>
<%@page import="Model.Room"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}

RoomDao roomDao = new RoomDao();
List<Room> rooms = roomDao.selectAllRooms();
%>
    <%
   
    Boolean authenticated = (Boolean) session.getAttribute("authenticated");

    if (authenticated == null || !authenticated) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <title>Room List</title>
   <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@include file="/includes/navbar.jsp"%>

<div class="container">
		<div class="card-header my-3">All ROOMS</div>
		 <div class="row mb-3">
            <div class="col-md-6">
                <form class="form-inline">
                    <div class="form-group">
                        <input type="text" class="form-control" id="searchInput" placeholder="Search Product">
                    </div>
                    <div class="form-group ml-2">
                        <select class="form-control" id="categoryFilter">
                            <option value="">All Categories</option>
                            <option value="Single">Single</option>
                            <option value="Double">Double</option>
                            <option value="Luxury">Luxury</option>
                            <option value="Deluxe">Deluxe</option>
                            <!-- Add more options as needed -->
                        </select>
                    </div>
                    <button type="button" class="btn btn-primary ml-2" id="searchButton">Search</button>
                </form>
            </div>
        </div>
		<div class="row">
            <%
            if (!rooms.isEmpty()) {
                for (Room room : rooms) {
            %>
            <div class="col-md-3 my-3">
                <div class="card w-100">
                    <img class="card-img-top" src="uploads/<%= room.getImage() %>" alt="Room Image">
                    <div class="card-body">
                        <h5 class="card-title"><%= room.getRoomNumber() %></h5>
                        <h6 class="category">Category: <%= room.getCategory() %></h6>
                        <h6 class="status">Status: <%= room.getStatus() %></h6>
                        <div class="mt-3 d-flex justify-content-between">
                           
                            <a class="btn btn-primary" href="RoomDetail?action=edit&roomID=<%= room.getRoomID() %>">Book Now</a> <!-- Replace this link as needed -->
                        </div>
                    </div>
                </div>
            </div>
            <%
                }
            } else {
                out.println("There are no rooms");
            }
            %>
        </div>
    </div>

    <%@include file="/includes/footer.jsp"%>
</body>
</html>