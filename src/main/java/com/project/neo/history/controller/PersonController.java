package com.project.neo.history.controller;

import com.project.neo.history.config.StorageProperties;
import com.project.neo.history.entity.Event;
import com.project.neo.history.entity.PartnerRelationship;
import com.project.neo.history.entity.Person;
import com.project.neo.history.entity.PersonDetail;
import com.project.neo.history.service.EventRepository;
import com.project.neo.history.service.FileSystemStorageService;
import com.project.neo.history.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @Autowired
    private StorageProperties properties;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/api/v1/getPersonDetails/{name}")
    public List<PersonDetail> getPersonDetails(@PathVariable String name){
        List<PersonDetail> personDetails = personRepository.getDetailsByName(name);
        for(PersonDetail personDetail : personDetails) {
            List<Event> eventList = eventRepository.findAllByPersonsName(personDetail.getName());
            for(Event event : eventList) {
                List<Person> persons = event.getPersons();
                persons = persons.stream().filter(x -> x.getName().equals(name) == false).collect(Collectors.toList());
                event.setPersons(persons);
            }
            personDetail.setEvents(eventList);
        }
        return personDetails;
    }

    @PostMapping("/api/v1/uploadPortrait")
    public String uploadPortrait(@RequestParam("file") MultipartFile file){

        String realName = file.getOriginalFilename();
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
