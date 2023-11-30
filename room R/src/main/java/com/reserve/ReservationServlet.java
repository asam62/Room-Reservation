package com.reserve;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.Reservation;
import Model.Room;

import java.io.IOException;
import java.sql.SQLException;


import Dao.RoomDao;
import Dao.ReservationDao;

@WebServlet
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDao reservedao;
	private RoomDao roomdao;
	int reserveId;
  
    public ReservationServlet()throws ClassNotFoundException, SQLException {
        super();
        // TODO Auto-generated constructor stub
        reservedao = new ReservationDao();
        roomdao = new RoomDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		String forward="";
		
		if(action == null)
		{
			action="default";
		}
		
		switch(action) {
		
		case "delete" :
			
			
			reserveId = Integer.parseInt(request.getParameter("reservationsID"));
			reservedao.deleteBooking(reserveId);
			RequestDispatcher del = request.getRequestDispatcher("ViewReservation.jsp");
			request.setAttribute("reservation", reservedao.getUserReservations(reserveId));
			del.forward(request, response);
			
			
			break;
			
		case "edit" :
			
			
			RequestDispatcher upd = request.getRequestDispatcher("reservationDetails.jsp");
			
			//forward ="AddRooms.jsp";
			int roomId = Integer.parseInt(request.getParameter("roomID"));
			int rId = Integer.parseInt(request.getParameter("reservationsID"));
		
			session.setAttribute("reservationID", rId);
			
			Reservation reserve = reservedao.getReservationById(rId);
			request.setAttribute("reservation", reserve);
			
			Room room = roomdao.getRoomById(roomId);
			request.setAttribute("room", room);
			upd.forward(request, response);
			
			
			break;
			
		default:
			
			HttpSession sessions = request.getSession();
			
			int userId = (int)sessions.getAttribute("userID");
			
			 RequestDispatcher view = request.getRequestDispatcher("ViewReservation.jsp");
			 request.setAttribute("reservations", reservedao.getUserReservations(userId));
			 view.forward(request, response);
			 break;
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	
	/*
	private void updateStatus(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		int reserveId = Integer.parseInt(request.getParameter("reservationsID"));
		RequestDispatcher updatestat = request.getRequestDispatcher("ViewReservation.jsp");
		reservedao.updateReservationStatus(reserveId);
		
		updatestat.forward(request, response);
		
		
		
	}
	*/

}