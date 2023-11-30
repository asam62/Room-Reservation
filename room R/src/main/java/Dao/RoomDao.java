package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Dbonnect;
import Model.Reservation;
import Model.Room;

public class RoomDao {

     
	
	private static final String INSERT_ROOM_SQL = "INSERT INTO rooms" + "  (RoomNumber,Category,Status,Capacity,description,image) VALUES " + " (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ROOM_BY_ID = "select * from rooms where RoomID =?";
	private static final String SELECT_ALL_ROOMS = "select * from rooms";
	private static final String DELETE_ROOM_SQL = "delete from rooms where RoomID = ?";
	private static final String UPDATE_ROOM_SQL = "update rooms set RoomNumber = ?,Category= ?, Status =?, Capacity=?,description=?, image=?  where RoomID = ?";

	
	Connection connection;
	
	public RoomDao()throws ClassNotFoundException, SQLException {
		
		connection = Dbonnect.getConnection();
	}
	
	public boolean addRoom(Room room) throws SQLException {
		System.out.println(INSERT_ROOM_SQL);
	
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL);
			preparedStatement.setString(1, room.getRoomNumber());
			preparedStatement.setString(2, room.getCategory());
			preparedStatement.setInt(3, room.getStatus());
			preparedStatement.setInt(4, room.getCapacity());
			preparedStatement.setString(5, room.getDescription());
			preparedStatement.setString(6, room.getImage());
			
		
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			return true;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Room getRoomById(int id) {
		Room room = new Room();
		// Step 1: Establishing a Connection
		try {
				
			
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				room.setRoomID(rs.getInt("RoomID"));
				room.setRoomNumber(rs.getString("RoomNumber"));
				room.setCategory(rs.getString("Category"));
				room.setStatus(Integer.parseInt(rs.getString("Status")));
				room.setCapacity(Integer.parseInt(rs.getString("Capacity")));
				room.setDescription(rs.getString("description"));
				room.setImage(rs.getString("image"));
				
			
			}
			}
		 catch (SQLException e) {
			 
			e.getStackTrace();
		}
		return room;
	}
	
	
	public List<Room> selectAllRooms() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Room> rooms = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			
		

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);
			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				Room room =new Room();
				
				room.setRoomNumber(rs.getString("RoomNumber"));
				room.setCategory(rs.getString("Category"));
				room.setStatus(Integer.parseInt(rs.getString("Status")));
				room.setCapacity(Integer.parseInt(rs.getString("Capacity")));
				room.setDescription(rs.getString("description"));
				room.setImage(rs.getString("image"));
				room.setRoomID(rs.getInt("RoomID"));
				
				rooms.add(room);
				
				//rooms.add(new Room(id, room_no,category, status, capacity,desc,photo));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return rooms;
	}
	
	

	
	public void deleteRoom(int id) {
		
		try {
			
		
			PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_SQL);
			statement.setInt(1, id);
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}
	
	public boolean updateRoom(Room room) {
		
		try {
			
			

			// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM_SQL);
		
		ResultSet rs = preparedStatement.executeQuery();

		// Step 4: Process the ResultSet object.
		while (rs.next()) {
			
			preparedStatement.setString(1, room.getRoomNumber());
			preparedStatement.setString(2, room.getCategory());
			preparedStatement.setInt(3, room.getStatus());
			preparedStatement.setInt(4, room.getCapacity());
			preparedStatement.setString(5, room.getDescription());
			preparedStatement.setString(6, room.getImage());
			preparedStatement.setInt(7, room.getRoomID());
			
			preparedStatement.executeUpdate();
			
		
		}
	} catch (SQLException e) {
		e.getStackTrace();
	}
		return false;
		
	
		
	}
	
	public List<Room> getAllAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            String query = "SELECT * FROM rooms WHERE Status = 1"; // Assuming Status 1 means available
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

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
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return rooms;
    }

    public List<Reservation> getUserReservations(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        try {
            String query = "SELECT * FROM reservations WHERE userId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation();
                // Populate reservation fields from the ResultSet
                // reservation.setReservationId(rs.getInt("reservationId"));
                // reservation.setUserId(rs.getInt("userId"));
                // ... Other fields

                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return reservations;
    }

    // ... Other methods ...

}

