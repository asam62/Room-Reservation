package com.reserve;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Model.Room;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchRoom")
public class searchRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchInput");
        if (searchTerm != null && !searchTerm.isEmpty()) {
        	try {
        	    List<Room> rooms = searchTerm != null && !searchTerm.isEmpty()
        	        ? searchRooms(searchTerm)
        	        : retrieveRoomsFromDatabase();
        	    
        	    request.setAttribute("rooms", rooms);
        	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/searchResults.jsp");
        	    dispatcher.include(request, response);
        	} catch (SQLException e) {
        	    e.printStackTrace();
        	    // Handle the exception if needed
        	}
        } else {
            List<Room> rooms = null;
			try {
				rooms = retrieveRoomsFromDatabase();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            request.setAttribute("rooms", rooms);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewRooms.jsp");
        dispatcher.forward(request, response);
    }

    private List<Room> retrieveRoomsFromDatabase() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM rooms");
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Room room = createRoomFromResultSet(rs);
                rooms.add(room);
            }
        }
        return rooms;
    }

    private List<Room> searchRooms(String searchTerm) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM rooms WHERE Category LIKE ?");
        ) {
            preparedStatement.setString(1, "%" + searchTerm + "%");
            
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Room room = createRoomFromResultSet(rs);
                    rooms.add(room);
                }
            }
        }
        return rooms;
    }

    private Room createRoomFromResultSet(ResultSet rs) throws SQLException {
        Room room = new Room();
        room.setRoomID(rs.getInt("RoomID"));
        room.setRoomNumber(rs.getString("RoomNumber"));
        room.setCategory(rs.getString("Category"));
        room.setStatus(rs.getInt("Status"));
        room.setCapacity(rs.getInt("Capacity"));
        room.setDescription(rs.getString("description"));
        room.setImage(rs.getString("image"));
        return room;
    }

    private Connection getConnection() throws SQLException {
        // Replace with your database connection details
        String url = "jdbc:mysql://localhost:3306/room_manager";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }
}
