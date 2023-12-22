package com.aliezkan.cacheplayground.controller;

import com.aliezkan.cacheplayground.domain.Person;
import com.aliezkan.cacheplayground.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playground/api/")
public class PlaygroundController {

    private final PersonService personService;

    @GetMapping("/person-info/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
}
