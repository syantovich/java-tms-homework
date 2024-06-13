package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.services.DatabaseService;
import org.example.models.entity.Film;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/add-film")
public class AddFilmController {

    private final DatabaseService databaseService;

    @GetMapping
    protected String doGet() {
        return "/add-film";
    }

    @PostMapping
    protected String doPost(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "year") int year,
            @RequestParam(name = "viewed",required = false) boolean viewed
    ) {
        try {
            databaseService.addFilm(new Film(name, description, year, viewed));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/all";
    }
}
