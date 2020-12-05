package com.project.neo.history.controller;

import com.project.neo.history.entity.PersonDetail;
import com.project.neo.history.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/api/v1/get/{name}")
    public PersonDetail getPersonDetails(@PathVariable String name){
        return personRepository.getDetailsByName(name);
    }


}
