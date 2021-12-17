package ru.netology.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping("/by-city")
    @Secured("ROLE_READ")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping("/all")
    @PreAuthorize("authentication.principal.username == 'Ivan'")
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}