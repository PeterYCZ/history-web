package com.project.neo.history.controller;

import com.project.neo.history.config.StorageProperties;
import com.project.neo.history.entity.*;
import com.project.neo.history.service.EventRepository;
import com.project.neo.history.service.FileSystemStorageService;
import com.project.neo.history.service.PersonRepository;
import com.project.neo.history.service.RelationshipRepository;
import com.project.neo.history.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {

    private static final SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    @Autowired
    private EventController eventController;

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @Autowired
    private StorageProperties properties;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RelationshipRepository relationshipRepository;

    @GetMapping("/api/v1/getPersonDetails/{name}")
    public GraphDataVO getPersonDetails(@PathVariable String name){
        GraphDataVO graphDataVO = new GraphDataVO();
        List<PersonDetail> personDetails = personRepository.getDetailsByName(name);
        for(PersonDetail personDetail : personDetails) {
            List<Event> eventList = eventRepository.findAllByPersonsName(personDetail.getName());
            personDetail.setEvents(eventList);
        }
        for(PersonDetail personDetail : personDetails) {
            Person personMain = Person.convert(personDetail);
            graphDataVO.addData(personMain);
            GraphDataVO.addFromEvent(graphDataVO,personDetail.getEvents());
        }
        return graphDataVO;
    }

    @PostMapping("/api/v1/uploadPortrait")
    public String uploadPortrait(@RequestParam("file") MultipartFile file){

        String realName = file.getOriginalFilename();
        String path = properties.getLocation()+"/"+realName;
        fileSystemStorageService.store(file);
        return path;
    }

    @GetMapping("/api/v1/getPortrait/")
    public byte[] getPortrait(@Param("path") String path) throws IOException {

        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;

    }

    @PostMapping("/api/v1/insertPerson")
    public Person insertPerson(@RequestBody Person person){
        String name = String.valueOf(idWorker.nextId());
        String realname = person.getName();
        Integer birthyear = person.getBirthyear();
        Integer deathyear = person.getDeathyear();
        String path = person.getPortrait();
        String lifeStory = person.getLifeStory();
        Event event = eventController.insertEvent(new Event("出生",realname +"出生"));
        person = personRepository.inertPerson(name,realname,birthyear,deathyear,path,lifeStory);
        relationshipRepository.personToEvent(person.getName(),event.getName());
        return person;
    }

    @PostMapping("/api/v1/create/relationship/")
    public PersonDetail createPartner(@RequestBody PartnerRelationship partnerRelationship){
        String husband = partnerRelationship.getHusband();
        String wife = partnerRelationship.getWife();
        return personRepository.createPartner(husband,wife);
    }

}
