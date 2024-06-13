package org.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.models.entity.Film;
import org.example.services.DatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/all")
public class AllFilmsController {
    private final DatabaseService databaseService;

    @GetMapping
    protected String doGet(HttpServletRequest req) {
        List<Film> allFilms = databaseService.getAllFilms();
        req.setAttribute("films", allFilms);
        return "/all-films";
    }
}
