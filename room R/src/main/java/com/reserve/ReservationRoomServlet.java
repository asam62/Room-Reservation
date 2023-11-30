package com.reserve;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.text.SimpleDateFormat;



import Dao.Dbonnect;
import Dao.ReservationDao;
import Model.Reservation;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet
public class ReservationRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
    	
try {
            
            HttpSession session = request.getSession();
   
            int userID =(int)(session.getAttribute("userID"));
            //User auth = (User) request.getSession().getAttribute("auth");
            int roomID = Integer.parseInt(request.getParameter("roomID"));
            String fullname = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phoneNo = request.getParameter("phoneNo");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            int status = Integer.parseInt(request.getParameter("status"));
            int reservationNo =Integer.parseInt(generateRandomNumberString(7));
            

           
                //String roomId = request.getParameter("roomID"); // Assuming you pass the room ID as "roomID"
                
                Reservation reservationModel = new Reservation();
                reservationModel.setRoomId(roomID);
                reservationModel.setUserId(userID);
                
                reservationModel.setReservationNumber(reservationNo);
                reservationModel.setFullName( fullname);
                reservationModel.setEmail( email);
                reservationModel.setPhoneNo( phoneNo);
                reservationModel.setGender( gender);
                reservationModel.setAddress( address);
                reservationModel.setStartDate(startDate);
                reservationModel.setEndDate(endDate);
                reservationModel.setStatus( status);
                

                ReservationDao reservationDao = new ReservationDao();
                boolean result = reservationDao.insertReservation(reservationModel);
                if (result) {
                    // Redirect to a success page or display a success message
                    response.sendRedirect("confirmation.jsp");
                } else {
                    // Display an error message
                    
                }
            

        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        } 

    }
    
    public static String generateRandomNumberString(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(10); // Generates a random number between 0 and 9
            stringBuilder.append(randomNumber);
        }

        return stringBuilder.toString();
    }
}
