package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.enums.PersonFindType;
import org.example.search.PersonSearch;
import org.example.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("/find")
    public String findPerson(@RequestHeader(name = "x-find-type", defaultValue = "ALL", required = false) PersonFindType findType, PersonSearch personSearch) {
        List<PersonEntity> persons = new ArrayList<>();
        switch (findType) {
            case ALL -> persons.addAll(personService.find(personSearch));
            case NAME_EQ -> persons.addAll(personService.findByName(personSearch.getFirstName()));
            case AGE_LESS_THAN -> persons.addAll(personService.findAllWhereAgeLessThan(personSearch.getMaxAge()));
        }

        return "";

    }
}
