package com.ifound.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifound.model.LostItem;
import com.ifound.dao.LostItemDAO;

public class LostItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LostItemDAO lostItemDAO;

    public void init() {
        lostItemDAO = new LostItemDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getPathInfo(); // gets path after /lost-items/

        if (action == null) {
            action = "/";
        }

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertLostItem(request, response);
                    break;
                case "/delete":
                    deleteLostItem(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateLostItem(request, response);
                    break;
                case "/":
                default:
                    listLostItems(request, response);
                    break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }

    private void listLostItems(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<LostItem> listLostItems = lostItemDAO.selectAllLostItems();
        request.setAttribute("listLostItems", listLostItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/items/lost-item-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/items/lost-item-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        LostItem existingLostItem = lostItemDAO.selectLostItem(id);
        request.setAttribute("lostItem", existingLostItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/items/lost-item-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertLostItem(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ParseException {
        String name = request.getParameter("name");
        String founder = request.getParameter("founder");
        String location = request.getParameter("location");
        String dateStr = request.getParameter("date");

        // Parse the date string to Timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date parsedDate = dateFormat.parse(dateStr);
        java.sql.Timestamp date = new java.sql.Timestamp(parsedDate.getTime());

        LostItem newLostItem = new LostItem(name, founder, location, date);
        lostItemDAO.insertLostItem(newLostItem);
        response.sendRedirect(request.getContextPath() + "/lost-items/");
    }

    private void updateLostItem(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String founder = request.getParameter("founder");
        String location = request.getParameter("location");
        String dateStr = request.getParameter("date");

        // Parse the date string to Timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date parsedDate = dateFormat.parse(dateStr);
        java.sql.Timestamp date = new java.sql.Timestamp(parsedDate.getTime());

        LostItem lostItem = new LostItem(id, name, founder, location, date);
        lostItemDAO.updateLostItem(lostItem);
        response.sendRedirect(request.getContextPath() + "/lost-items/");
    }

    private void deleteLostItem(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        lostItemDAO.deleteLostItem(id);
        response.sendRedirect(request.getContextPath() + "/lost-items/");
    }
}
