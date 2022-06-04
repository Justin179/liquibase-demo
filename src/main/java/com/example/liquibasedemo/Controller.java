package com.example.liquibasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class Controller {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("person")
    public String createPerson(@RequestParam String name){
        personRepository.save(new Person(name,"6.6"));
        return personRepository.findByName(name) + " saved successfully";
    }

    @GetMapping("person")
    public List<Person> getAllThePeople(){
        return (List<Person>) personRepository.findAll();
    }
}
