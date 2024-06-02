package org.example.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DatabaseService;
import org.example.Film;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/edit")
public class Edit extends HttpServlet {
    DatabaseService service = new DatabaseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("editId", req.getParameter("id"));
        req.setAttribute("films", service.getAllFilms());
        req.getRequestDispatcher("/WEB-INF/all-films.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int year = Integer.parseInt(req.getParameter("year"));
        boolean viewed = req.getParameter("viewed") != null;
        try {
            service.updateFilm(new Film(UUID.fromString(uuid), name, description, year, viewed));
        } catch (Exception e) {
            throw new ServletException(e);
        }
        resp.sendRedirect("/all");
    }
}

