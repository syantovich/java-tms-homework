package org.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.services.DatabaseService;
import org.example.models.entity.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/edit")
@RequiredArgsConstructor
@Controller
public class EditController {
    private final DatabaseService databaseService;

    @PostMapping
    protected String doPost(
            HttpServletRequest req,
            @ModelAttribute(name = "filmModel") @Valid Film film,
            BindingResult bindingResult,
            Model model
    ) throws ServletException {
        try {
            throw new RuntimeException();
//            if (!bindingResult.hasErrors()) {
//                databaseService.updateFilm(film);
//                return "redirect:/all";
//            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
//        return "/add-film";
    }
}

