package org.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DatabaseService;

import java.io.IOException;

@WebServlet("/all")
public class AllFilms extends HttpServlet {
    DatabaseService service = new DatabaseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("films", service.getAllFilms());
        req.getRequestDispatcher("/WEB-INF/all-films.jsp").forward(req, resp);
    }
}
