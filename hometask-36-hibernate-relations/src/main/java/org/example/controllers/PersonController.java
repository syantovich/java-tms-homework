package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    private String savePerson(@RequestParam(name = "lastName") String lastName, @RequestParam(name = "firstName") String firstName) {

        PersonEntity person = new PersonEntity();
        person.setLastName(lastName);
        person.setFirstName(firstName);
        personService.save(person);
        return "";
    }

    @DeleteMapping("/{id}")
    public void removePerson(@PathVariable(name = "id") String uuid) {
        personService.delete(UUID.fromString(uuid));
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable(name = "id") String uuid) {
        PersonEntity person = personService.findById(UUID.fromString(uuid));

        return "";
    }
}
