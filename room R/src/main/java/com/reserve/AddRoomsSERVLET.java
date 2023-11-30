package com.reserve;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import Model.Room;
import Dao.RoomDao;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/addRooms")
@MultipartConfig(maxFileSize = 16177215)
public class AddRoomsSERVLET extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";
    private RoomDao roomdao;

    public AddRoomsSERVLET() throws ClassNotFoundException, SQLException {
        super();
        roomdao = new RoomDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        String action = request.getParameter("action");

        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "delete":
                int roomId = Integer.parseInt(request.getParameter("roomID"));
                roomdao.deleteRoom(roomId);
                RequestDispatcher del = request.getRequestDispatcher("ViewRooms.jsp");
                request.setAttribute("rooms", roomdao.selectAllRooms());
                del.forward(request, response);
                break;

            case "edit":
                int rId = Integer.parseInt(request.getParameter("roomID"));
                Room room = roomdao.getRoomById(rId);
                request.setAttribute("room", room);
                RequestDispatcher upd = request.getRequestDispatcher("AddRooms.jsp");
                upd.forward(request, response);
                break;

            default:
                RequestDispatcher view = request.getRequestDispatcher("ViewRooms.jsp");
                request.setAttribute("rooms", roomdao.selectAllRooms());
                view.forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            insertRoom(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String roomNumber = request.getParameter("roomNumber");
        String category = request.getParameter("category");
        int status = 0;
        int capacity = 0;
        String description = request.getParameter("description");

        try {
            status = Integer.parseInt(request.getParameter("status"));
            capacity = Integer.parseInt(request.getParameter("capacity"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        Path uploadDir = Path.of(uploadPath);
        Files.createDirectories(uploadDir);

        try (InputStream inputStream = filePart.getInputStream()) {
            Path filePath = uploadDir.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        Room room = new Room(roomNumber, category, status, capacity, description, fileName);

        String roomID = request.getParameter("roomID");
        if (roomID == null || roomID.isEmpty()) {
            boolean roomAdded = roomdao.addRoom(room);

            if (roomAdded) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }
        } else {
            room.setRoomID(Integer.parseInt(roomID));
            boolean roomUpdate = roomdao.updateRoom(room);

            if (roomUpdate) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewRooms.jsp");
        dispatcher.forward(request, response);
    }
}
