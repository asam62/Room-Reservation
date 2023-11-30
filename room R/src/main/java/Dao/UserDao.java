package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Dbonnect;
import Model.Room;
import Model.User;

public class UserDao {

	
	
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String DELETE_USER_SQL = "delete from user where id = ?";
	
	Connection connection;
	
	public UserDao()throws ClassNotFoundException, SQLException {
		
		connection = Dbonnect.getConnection();
	}
	
	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			
		

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				User user =new User();
				
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setId(rs.getInt("id"));
				
				users.add(user);
				
				//rooms.add(new Room(id, room_no,category, status, capacity,desc,photo));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return users;
	}
	
	
		public void deleteUser(int id) {
				
				try {
					
				
					PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);
					statement.setInt(1, id);
					statement.executeUpdate();
				}
				catch (SQLException e) {
					e.getStackTrace();
				}
				
				
			}

}