package org.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.services.DatabaseService;
import org.example.models.entity.Film;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.UUID;

@RequestMapping("/edit")
@RequiredArgsConstructor
@Controller
public class EditController {
    private final DatabaseService databaseService;

    @GetMapping
    protected String doGet(HttpServletRequest req, @RequestParam(name = "id") String id) {
        req.setAttribute("editId", req.getParameter("id"));
        req.setAttribute("films", databaseService.getAllFilms());
        return "/all-films";

    }

    @PostMapping
    protected String doPost(
            HttpServletRequest req,
            @RequestParam(name = "uuid") String uuid,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "year") int year,
            @RequestParam(name = "viewed", required = false) boolean viewed
    ) throws ServletException, IOException {
        try {
            databaseService.updateFilm(new Film(UUID.fromString(uuid), name, description, year, viewed));
        } catch (Exception e) {
            throw new ServletException(e);
        }
        return "redirect:/all";
    }
}

