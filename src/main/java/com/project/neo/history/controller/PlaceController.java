package com.project.neo.history.controller;

import com.project.neo.history.entity.Countryman;
import com.project.neo.history.entity.PersonDetail;
import com.project.neo.history.service.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/api/v1/getcountryman/{name}")
    public Countryman getPersonDetails(@PathVariable String name){
        return placeRepository.getCountrymanList(name);
    }


}
