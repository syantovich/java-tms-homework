package org.example.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DatabaseService;
import org.example.Film;

import java.io.IOException;

@WebServlet("/add-film")
public class AddFilm extends HttpServlet {
    DatabaseService service = new DatabaseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add-film.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int year = Integer.parseInt(req.getParameter("year"));
        boolean viewed = req.getParameter("viewed") != null;
        try {
            service.addFilm(new Film(name, description, year, viewed));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/all");
    }
}
