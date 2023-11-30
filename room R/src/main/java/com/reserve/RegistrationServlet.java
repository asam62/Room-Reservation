package com.reserve;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/register")
    public class RegistrationServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        
        public RegistrationServlet() {
            super();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        	String role = "userh";
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            String Role = role;
            Connection con = null;
            RequestDispatcher dispatcher = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_manager?useSSL=false", "root", "root");
                PreparedStatement pst = con.prepareStatement("INSERT INTO user(username, email, password,role) VALUES (?, ?, ?,?)");
                    pst.setString(1, username);
                    pst.setString(2, email);
                    pst.setString(3, password);
                    pst.setString(4, role);

                    int rowCount = pst.executeUpdate();
                    dispatcher = request.getRequestDispatcher("registration.jsp");
                    if (rowCount > 0) {
                        request.setAttribute("status", "success");
                    } else {
                        request.setAttribute("status", "failed");
                    }
                    dispatcher = request.getRequestDispatcher("registration.jsp");
                    dispatcher.forward(request, response);
                    con.commit(); // Commit the transaction
                 
            }catch(Exception e) {
                e.printStackTrace();
                try {
    				con.rollback();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} // Rollback the transaction on error
            } finally {
                try {
                    con.close();
                    }
             catch (SQLException e) {
                e.printStackTrace();
            }
        }
   
    }

    }


