package com.example.hometask46.controllers;

import com.example.hometask46.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class PagesController {
    private final PersonService personService;

    @GetMapping("/auth-info")
    public String authInfo(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("isAdmin", personService.isAdministrator(userDetails));
        return "auth-info";
    }

    @GetMapping("/admin-page")
    public String adminPage() {
        return "admin-page";
    }

    @GetMapping("/no-access")
    public String noAccess() {
        return "no-access";
    }
}
