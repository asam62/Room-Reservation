<%@page import="java.text.DecimalFormat"%>
<%@page import="Dao.RoomDao"%>
<%@page import="Model.Room"%>
<%@page import="Model.Reservation"%>
<%@page import="Model.User"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);

    RoomDao roomDao = new RoomDao();
    List<Room> availableRooms = roomDao.getAllAvailableRooms(); // Assume this method gets available rooms

    // You can fetch user's reservations here and display them in a similar manner
    List<Reservation> userReservations = roomDao.getUserReservations(auth.getId());

} else {
    response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <title>Room Reservation</title>
</head>
<body>
    <%@include file="/includes/navbar.jsp"%>
    <div class="container">
        <div class="card-header my-3">Room Reservations</div>
        <table class="table table-light">
            <thead>
            <tr>
                <th scope="col">Room Number</th>
                <th scope="col">Category</th>
                <th scope="col">Status</th>
                <th scope="col">Capacity</th>
                <th scope="col">Description</th>
                <th scope="col">Image</th>
                <th scope="col">Reserve</th>
            </tr>
            </thead>
            <tbody>
            <% 
    List<Room> availableRooms = (List<Room>) request.getAttribute("availableRooms");
    if (availableRooms != null) {
        for (Room room : availableRooms) {
%>
            <tr>
                <td><%= room.getRoomNumber() %></td>
                <td><%= room.getCategory() %></td>
                <td><%= room.getStatus() %></td>
                <td><%= room.getCapacity() %></td>
                <td><%= room.getDescription() %></td>
                <td><img src="<%= room.getImage() %>" alt="Room Image" width="100"></td>
                <td>
                    <form action="reserve-room" method="post">
                        <input type="hidden" name="roomID" value="<%= room.getRoomID() %>">
                        <button type="submit" class="btn btn-primary">Reserve</button>
                    </form>
                </td>
            </tr>
          <%
    }
}
%>
            </tbody>
        </table>
    </div>
    <%@include file="/includes/footer.jsp"%>
</body>
</html>
