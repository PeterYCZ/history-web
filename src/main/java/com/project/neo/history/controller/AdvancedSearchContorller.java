package com.project.neo.history.controller;

import com.project.neo.history.entity.*;
import com.project.neo.history.service.AdvancedSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdvancedSearchContorller {

    @Autowired
    private AdvancedSearchService advancedSearchService;

    @PostMapping("/api/v1/advancedsearch/")
    public GraphDataVO listEvents(@RequestBody AdvancedSearchDTO advancedSearchDTO) {
        AdvancedSearchVO advancedSearchVO = advancedSearchService.listEvents(advancedSearchDTO);
        GraphDataVO graphDataVO = createFromAdvancedSearch(advancedSearchVO);
        return graphDataVO;
    }

    public static GraphDataVO createFromAdvancedSearch(AdvancedSearchVO advancedSearchVO) {
        GraphDataVO graphDataVO = new GraphDataVO();
        List<Event> events = advancedSearchVO.getEventList();
        if(events != null && events.size() > 0) {
            GraphDataVO.addFromEvent(graphDataVO,events);
        }
        return graphDataVO;
    }
}
