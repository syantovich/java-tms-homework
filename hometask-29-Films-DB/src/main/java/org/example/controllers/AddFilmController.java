package org.example.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.models.entity.Film;
import org.example.services.DatabaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/add-film")
public class AddFilmController {

    private final DatabaseService databaseService;

    @GetMapping
    protected String doGet(@ModelAttribute(name = "filmModel") Film film, @RequestParam(name = "id", required = false) String editId, Model model) {
        if (editId != null) {
            model.addAttribute("isEdit", true);
            Film nextFilm = databaseService.getFilm(UUID.fromString(editId));
            System.out.println(nextFilm);
            if (nextFilm != null) {
                film.setFilmName(nextFilm.getFilmName());
                film.setDescription(nextFilm.getDescription());
                film.setYear(nextFilm.getYear());
                film.setViewed(nextFilm.isViewed());
                film.setUuid(nextFilm.getUuid());
            }
        }
        return "/add-film";
    }

    @PostMapping
    protected String doPost(
            @ModelAttribute(name = "filmModel") @Valid @RequestBody Film film,
            BindingResult bindingResult
    ) {
        try {
            if (!bindingResult.hasErrors()) {
                databaseService.addFilm(film);
                return "redirect:/all";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "/add-film";
    }
}
