package ru.netology.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.getPersonsByCity(city);
    }
}