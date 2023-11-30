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

@WebServlet("/viewRooms")
public class ViewRoomsServlet extends HttpServlet {
    private static final String SELECT_ALL_ROOMS = "SELECT * FROM rooms";
    
	//List<Room> rooms = new ArrayList<>();
       
    
    public ViewRoomsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
   
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                List<Room> rooms = retrieveRoomsFromDatabase();
                request.setAttribute("rooms", rooms);
                RequestDispatcher dispatcher = request.getRequestDispatcher("SearchResults.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception if needed
            }
        }
        
        private List<Room> retrieveRoomsFromDatabase() throws SQLException {
            List<Room> rooms = new ArrayList<>();
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);
                 ResultSet rs = preparedStatement.executeQuery()) {
                
                while (rs.next()) {
                    Room room = new Room();
                    room.setRoomID(rs.getInt("RoomID"));
                    room.setRoomNumber(rs.getString("RoomNumber"));
                    room.setCategory(rs.getString("Category"));
                    room.setStatus(rs.getInt("Status"));
                    room.setCapacity(rs.getInt("Capacity"));
                    room.setDescription(rs.getString("description"));
                    room.setImage(rs.getString("image"));
                    rooms.add(room);
                }
            }
            return rooms;
        }
        
        private Connection getConnection() throws SQLException {
            // Replace with your database connection details
            String url = "jdbc:mysql://localhost:3306/room_manager";
            String user = "root";
            String password = "root";
            return DriverManager.getConnection(url, user, password);
        }
    }

