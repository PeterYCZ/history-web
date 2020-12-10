package com.project.neo.history.controller;

import com.project.neo.history.config.StorageProperties;
import com.project.neo.history.entity.PartnerRelationship;
import com.project.neo.history.entity.Person;
import com.project.neo.history.entity.PersonDetail;
import com.project.neo.history.service.FileSystemStorageService;
import com.project.neo.history.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @Autowired
    private StorageProperties properties;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/api/v1/getPersonDetails/{name}")
    public PersonDetail getPersonDetails(@PathVariable String name){
        return personRepository.getDetailsByName(name);
    }

    @PostMapping("/api/v1/uploadPortrait")
    public String uploadPortrait(@RequestParam("file") MultipartFile file){

        String realName = file.getOriginalFilename();
        LocalDateTime localDateTime = LocalDateTime.now();
        String uuid = UUID.randomUUID().toString().substring(0,6);
        String path = properties.getLocation()+"/"+realName;
        fileSystemStorageService.store(file);
        return path;
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
