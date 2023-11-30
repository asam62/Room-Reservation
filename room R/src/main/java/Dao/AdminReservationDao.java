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

public class AdminReservationDao {
	
	private static final String INSERT_RESERVATION_SQL = "INSERT INTO reservations" + "  (userID,roomID,fullName,email,phoneNo,gender,address,reservationNumber,startDate,endDate,status) VALUES " + " (?, ?, ?, ?, ?, ?,?,?,?,?,?)";
	private static final String SELECT_RESERVATION_BY_ID = "select * from reservations WHERE reservationsID=?";
	
	private static final String SELECT_ALL_RESERVATIONS = "select * from reservations R INNER JOIN user U ON R.reservationsID =user.id INNER JOIN rooms M ON R.roomID=M.roomID";
	private static final String SELECT_ALL_RESERVATIONS2 = "select * from reservations";
	
	private static final String DELETE_RESERVATION_SQL = "delete from reservations where reservationsID = ?";
	private static final String UPDATE_RESERVATION_SQL = "update reservations set RoomNumber = ?,Category= ?, Status =?, Capacity=?,description=?, image=?  where reservationsID = ?";
	
	private static final String UPDATE_RESERVATION_STATUS_SQL = "update reservations set Status =? where reservationsID = ?";

	
	
	Connection connection;
	
public AdminReservationDao()throws ClassNotFoundException, SQLException {
		
		connection = Dbonnect.getConnection();
	}


public List<Reservation> selectAllReservations() {

	// using try-with-resources to avoid closing resources (boiler plate code)
	List<Reservation> reservation = new ArrayList<>();
	// Step 1: Establishing a Connection
	try {
		
	
		

			// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATIONS2);
		
		ResultSet rs = preparedStatement.executeQuery();

		// Step 4: Process the ResultSet object.
		while (rs.next()) {
			
			Reservation reserve =new Reservation();
			
			reserve.setUserId(Integer.parseInt(rs.getString("userId")));
			reserve.setRoomId(Integer.parseInt(rs.getString("roomId")));
			reserve.setFullName(rs.getString("fullName"));
			reserve.setEmail(rs.getString("email"));
			reserve.setPhoneNo(rs.getString("phoneNo"));
			reserve.setGender(rs.getString("gender"));
			reserve.setAddress(rs.getString("address"));
			reserve.setReservationNumber(rs.getInt("reservationNumber"));
			reserve.setStartDate(rs.getString("startDate"));
			reserve.setEndDate(rs.getString("endDate"));
			reserve.setStatus(rs.getInt("status"));
			reserve.setReservationId(rs.getInt("reservationId"));
			
			reservation.add(reserve);
			
			//rooms.add(new Room(id, room_no,category, status, capacity,desc,photo));
		}
	} catch (SQLException e) {
		e.getStackTrace();
	}
	return reservation;
}


public Reservation getReservationById(int id) {
	Reservation reservation = new Reservation();
	// Step 1: Establishing a Connection
	try {
			
		
			// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVATION_BY_ID);
		preparedStatement.setInt(1, id);
		

		ResultSet rs = preparedStatement.executeQuery();

		// Step 4: Process the ResultSet object.
		while (rs.next()) {
			
			reservation.setReservationId(rs.getInt("reservationId"));
			reservation.setUserId(Integer.parseInt(rs.getString("userId")));
			reservation.setRoomId(Integer.parseInt(rs.getString("roomId")));
			reservation.setFullName(rs.getString("fullName"));
			reservation.setEmail(rs.getString("email"));
			reservation.setPhoneNo(rs.getString("phoneNo"));
			reservation.setGender(rs.getString("gender"));
			reservation.setAddress(rs.getString("address"));
			reservation.setReservationNumber(rs.getInt("reservationNumber"));
			reservation.setStartDate(rs.getString("startDate"));
			reservation.setEndDate(rs.getString("endDate"));
			reservation.setStatus(rs.getInt("status"));
			
			
		
		}
		}
	 catch (SQLException e) {
		 
		e.getStackTrace();
	}
	return reservation;
}


public void deleteBooking(int id) {
	
	try {
		
	
		PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION_SQL);
		statement.setInt(1, id);
		statement.executeUpdate();
	}
	catch (SQLException e) {
		e.getStackTrace();
	}
	
	
}


public void updateReservationStatus(int id) {
	
	try {
		
		

		// Step 2:Create a statement using connection object
	PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESERVATION_STATUS_SQL);
	
	ResultSet rs = preparedStatement.executeQuery();

	// Step 4: Process the ResultSet object.
	while (rs.next()) {
		
		preparedStatement.setInt(1, id);
		
		preparedStatement.executeUpdate();
		
	
	}
} catch (SQLException e) {
	e.getStackTrace();
}
	

	
}
	
}