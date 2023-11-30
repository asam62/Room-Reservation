package Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Reservation; // Update the import statement accordingly

public class ReservationDao {
	private static final String SELECT_RESERVATION_BY_ID = "select * from reservations WHERE reservationsID=?";
	private static final String DELETE_RESERVATION_SQL = "delete from reservations where reservationsID = ?";
    Connection connection;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
   

    public ReservationDao() throws ClassNotFoundException, SQLException {
       
    	connection = Dbonnect.getConnection();
    }

    public boolean insertReservation(Reservation reservation) {
        boolean result = false;
        try {
           query = "insert into reservations (userID, roomID, reservationNumber, fullName, email,phoneNo,gender,address, startDate, endDate, status) values(?,?,?,?,?,?,?,?,?,?,?)";
            pst = this.connection.prepareStatement(query);
            pst.setInt(1, reservation.getUserId());
            pst.setInt(2, reservation.getRoomId());
            pst.setInt(3, reservation.getReservationNumber());
            pst.setString(4, reservation.getFullName());
            pst.setString(5, reservation.getEmail());
            pst.setString(6, reservation.getPhoneNo());
            pst.setString(7, reservation.getGender());
            pst.setString(8, reservation.getAddress());
            pst.setString(9, reservation.getStartDate());
            pst.setString(10, reservation.getEndDate());
            pst.setInt(11, reservation.getStatus());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Reservation> getUserReservations(int userId) {
        List<Reservation> list = new ArrayList<>();
        try { 
            query = "select * from reservations where userID=? order by reservations.reservationsID desc";
            pst = this.connection.prepareStatement(query);
            pst.setInt(1, userId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                // You need to implement the RoomDao to retrieve room details
                // RoomDao roomDao = new RoomDao(this.con);
                // int roomId = rs.getInt("room_id");
                // Room room = roomDao.getRoomById(roomId);
                reservation.setReservationId(rs.getInt("reservationsID"));
                reservation.setUserId(rs.getInt("userID"));
                reservation.setRoomId(rs.getInt("roomID"));
                reservation.setReservationNumber(rs.getInt("reservationNumber"));
                 reservation.setFullName(rs.getString("fullName"));
                 reservation.setEmail(rs.getString("email"));
                 reservation.setPhoneNo(rs.getString("phoneNo"));
     			reservation.setGender(rs.getString("gender"));
     			reservation.setAddress(rs.getString("address"));
                 reservation.setStartDate(rs.getString("startDate"));
                 reservation.setEndDate(rs.getString("endDate"));
                 reservation.setStatus(rs.getInt("status"));
                list.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelReservation(int reservationId) {
        try {
            query = "delete from reservations where reservationsID=?";
            pst = connection.prepareStatement(query);
            pst.setInt(1, reservationId);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        
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
    			
    			reservation.setReservationId(rs.getInt("reservationsID"));
                reservation.setUserId(rs.getInt("userID"));
                reservation.setRoomId(rs.getInt("roomID"));
                reservation.setReservationNumber(rs.getInt("reservationNumber"));
                 reservation.setFullName(rs.getString("fullName"));
                 reservation.setEmail(rs.getString("email"));
                 reservation.setPhoneNo(rs.getString("phoneNo"));
      			reservation.setGender(rs.getString("gender"));
      			reservation.setAddress(rs.getString("address"));
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
}
