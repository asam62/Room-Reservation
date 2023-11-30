package com.reserve;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_manager?useSSL=false", "root", "root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            	
            		
            	String userRole = getUserRoleFromDatabase(email);
            	int userID = getUserIdFromDatabase(email);
                // Redirect to the protected page (e.g., welcome.jsp)
            	if(userRole.equals("userh"))
            	{
            		session.setAttribute("authenticated", true);
            		session.setAttribute("email", email);
            		session.setAttribute("userID", userID);
            		response.sendRedirect("welcome.jsp");
            	}
            	if(userRole.equals("admin")){
            		
            		session.setAttribute("authenticated", true);
            		session.setAttribute("email", email);
            		session.setAttribute("userID", userID);
            		response.sendRedirect("AdminPanel.jsp");
            	}
                
                
                
                
            } else {
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
	
	// Method to retrieve user's role from the database
    private String getUserRoleFromDatabase(String email) {
        String role = " "; // Default role
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_manager?useSSL=false", "root", "root");
            
            String query = "SELECT role FROM user WHERE email = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = resultSet.getString("role");
            }

            resultSet.close();
            preparedStatement.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return role;
    }
    
    
 // Method to retrieve user's role from the database
    private int getUserIdFromDatabase(String email) {
         // Default role
    	int uid = 0;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_manager?useSSL=false", "root", "root");
            
            String query = "SELECT id FROM user WHERE email = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                 uid = resultSet.getInt("id");
            }

            resultSet.close();
            preparedStatement.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return uid;
    }
    
    
	}