package ru.netology.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping("/by-city")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        return personRepository.findPersonByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return personRepository.findPersonByAgeLessThanSortedByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findPersonByNameAndSurname(name, surname);
    }
}