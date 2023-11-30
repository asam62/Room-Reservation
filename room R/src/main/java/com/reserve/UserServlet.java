package com.reserve;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Room;

import java.io.IOException;
import java.sql.SQLException;

import Dao.RoomDao;
import Dao.UserDao;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
    
	  public UserServlet() throws ClassNotFoundException, SQLException{
	        super();
	        userdao = new UserDao();
	    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String action = request.getParameter("action");
		String forward="";
		
		if(action == null)
		{
			action="default";
		}
		
		switch(action) {
		
		case "delete" :
			
			int userId = Integer.parseInt(request.getParameter("id"));
			userdao.deleteUser(userId);
			RequestDispatcher del = request.getRequestDispatcher("ViewUsers.jsp");
			request.setAttribute("users", userdao.selectAllUsers());
			del.forward(request, response);
			
			break;
			
		case "edit" :
			/*
			RequestDispatcher upd = request.getRequestDispatcher("AddRooms.jsp");
			//forward ="AddRooms.jsp";
			int rId = Integer.parseInt(request.getParameter("roomID"));
			Room room = roomdao.getRoomById(rId);
			request.setAttribute("room", room);
			upd.forward(request, response);
			*/
			break;
			
		default:
			
			 RequestDispatcher view = request.getRequestDispatcher("ViewUsers.jsp");
			 request.setAttribute("users", userdao.selectAllUsers());
			 view.forward(request, response);
			 break;
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}