package com.miguelfnunes.challenge.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguelfnunes.challenge.model.Activity;
import com.miguelfnunes.challenge.service.ActivityService;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j
@RestController
public class ActivityController {

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    public ActivityController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    @Autowired
    private ActivityService activityService;


    @RequestMapping(value = "/activity", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Activity> getActivity() {
        log.info("Get activity");
        return new ResponseEntity<Activity>(activityService.getActivityById(request.getHeader("ID")), HttpStatus.OK);
    }

    @RequestMapping(value = "/activities", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<List<Activity>> getActivities() throws JsonProcessingException {
        log.info("Get activities");
        return new ResponseEntity<List<Activity>>(activityService.getAllActivities(), HttpStatus.OK);
    }
}
