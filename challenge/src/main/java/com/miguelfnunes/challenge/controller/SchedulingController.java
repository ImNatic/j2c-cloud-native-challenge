package com.miguelfnunes.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguelfnunes.challenge.exception.IDNotFound;
import com.miguelfnunes.challenge.model.Scheduling;
import com.miguelfnunes.challenge.service.SchedulingService;
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
public class SchedulingController {

    private final HttpServletRequest request;


    @Autowired
    public SchedulingController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }
    @Autowired
    private SchedulingService schedulingService;


    @RequestMapping(value = "/scheduling", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<Object> getScheduling(){
        log.info("Get scheduling");
        return new ResponseEntity<Object>(schedulingService.getSchedulingById(request.getHeader("ID")), HttpStatus.OK);
    }

    @RequestMapping(value = "/schedules", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Scheduling>> getSchedules(){
        log.info("Get schedules");
        return new ResponseEntity<List<Scheduling>>(schedulingService.getSchedulingByCustomerId(request.getHeader("ID")), HttpStatus.OK);
    }

    @RequestMapping(value = "/scheduling", method = RequestMethod.DELETE)
    ResponseEntity<Void> removeScheduling() {
        log.info("Delete scheduling");
        schedulingService.deleteSchedulingById(request.getHeader("ID"));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
