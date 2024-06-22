package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.services.DatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RequestMapping("/delete")
@RequiredArgsConstructor
@Controller
public class DeleteFilmController {
    private final DatabaseService databaseService;

    @GetMapping
    protected String doGet(@RequestParam(name = "id") String uuid) {
        try {
            databaseService.deleteFilm(UUID.fromString(uuid));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/all";
    }
}
