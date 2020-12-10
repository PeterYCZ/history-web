package com.project.neo.history.controller;

import com.project.neo.history.entity.PartnerRelationship;
import com.project.neo.history.entity.Person;
import com.project.neo.history.entity.PersonDetail;
import com.project.neo.history.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/api/v1/getPersonDetails/{name}")
    public PersonDetail getPersonDetails(@PathVariable String name){
        return personRepository.getDetailsByName(name);
    }

    @PostMapping("/api/v1/uploadPortrait")
    public String uploadPortrait(@RequestParam("file") MultipartFile file){

        String realName = file.getOriginalFilename();
        String fileName = realName;
        String filePath = "./picture/";
        File portrait = new File(filePath + fileName);
        try {
            file.transferTo(portrait);
            return filePath + fileName;
        } catch (IOException e) {
        }
        return "上传失败！";
    }

    @PostMapping("/api/v1/insert")
    public Person insertPerson(@RequestBody Person person){
        String name = person.getName();
        Integer birthyear = person.getBirthyear();
        Integer deathyear = person.getDeathyear();
        String path = person.getPortrait();
        String lifeStory = person.getLifeStory();
        return personRepository.inertPerson(name,birthyear,deathyear,path,lifeStory);
    }

    @PostMapping("/api/v1/create/relationship/")
    public PersonDetail createPartner(@RequestBody PartnerRelationship partnerRelationship){
        String husband = partnerRelationship.getHusband();
        String wife = partnerRelationship.getWife();
        return personRepository.createPartner(husband,wife);
    }

}
