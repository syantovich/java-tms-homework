package org.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DatabaseService;
import org.example.FilmError;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/delete")
public class DeleteFilm extends HttpServlet {
    DatabaseService service = new DatabaseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("id");
        try {
            service.deleteFilm(UUID.fromString(uuid));
        } catch (FilmError e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/all");
    }
}
