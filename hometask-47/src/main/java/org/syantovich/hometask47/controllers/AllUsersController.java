package org.syantovich.hometask47.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.syantovich.hometask47.dto.PersonDto;
import org.syantovich.hometask47.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class AllUsersController {
    private final PersonService personService;

    @GetMapping("/all")
    public List<PersonDto> getAllUsers() {
        return personService.getAllUsers();
    }

    @GetMapping("/me")
    public PersonDto getMe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return personService.getPersonByEmail(authentication.getName());
    }

}
