package com.example.hometask46.controllers;

import com.example.hometask46.dto.RegisterDto;
import com.example.hometask46.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.example.hometask46.dto.SignDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final PersonService personService;

    @GetMapping
    public String register(Model model) {
        var registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        return "register";
    }

    @PostMapping
    public String register(RegisterDto registerDto) {
        personService.registerPerson(registerDto);
        return "redirect:/register";
    }
}
