package org.syantovich.hometask47.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.syantovich.hometask47.dto.AuthResponseDto;
import org.syantovich.hometask47.dto.LoginDto;
import org.syantovich.hometask47.dto.RegisterDto;
import org.syantovich.hometask47.services.PersonService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final PersonService personService;

    @PostMapping("/register")
    public AuthResponseDto registerPerson(@RequestBody RegisterDto registerDto) {
        return personService.registerPerson(registerDto);
    };

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginDto loginDto) {
        return personService.login(loginDto);
    };
}
