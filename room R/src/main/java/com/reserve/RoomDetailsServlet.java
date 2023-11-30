package com.reserve;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Dao.RoomDao;
import Model.Room;

/**
 * Servlet implementation class RoomDetailsServlet
 */
public class RoomDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomDao roomDao;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public RoomDetailsServlet() throws ClassNotFoundException, SQLException {
        super();
        roomDao = new RoomDao();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String action = request.getParameter("action");
		String forward="";
		
		if(action == null)
		{
			action="default";
		}
		
		switch(action) {
		
		case "delete" :
			
			int roomId = Integer.parseInt(request.getParameter("roomID"));
			roomDao.deleteRoom(roomId);
			RequestDispatcher del = request.getRequestDispatcher("ViewRooms.jsp");
			request.setAttribute("rooms", roomDao.selectAllRooms());
			del.forward(request, response);
			
			break;
			
		case "edit" :
			RequestDispatcher upd = request.getRequestDispatcher("roomDetails.jsp");
			//forward ="AddRooms.jsp";
			int rId = Integer.parseInt(request.getParameter("roomID"));
			Room room = roomDao.getRoomById(rId);
			request.setAttribute("room", room);
			upd.forward(request, response);
			
			break;
			
		default:
			
			 RequestDispatcher view = request.getRequestDispatcher("ViewRooms.jsp");
			 request.setAttribute("rooms", roomDao.selectAllRooms());
			 view.forward(request, response);
			 break;
			
		}
}}