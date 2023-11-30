<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Iterate through the rooms and display them --%>
<c:forEach var="room" items="${rooms}">
    <div class="room-item">
        <div>Room ID: ${room.roomID}</div>
        <div>Room Number: ${room.roomNumber}</div>
        <!-- Other room details -->
    </div>
</c:forEach>
