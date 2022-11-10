package com.miguelfnunes.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguelfnunes.challenge.model.Customer;
import com.miguelfnunes.challenge.service.CustomerService;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Log4j
@RestController
public class CustomerController {

    private final HttpServletRequest request;

    @Autowired
    public CustomerController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCustomer() {
        log.info("Delete customer");
        customerService.deleteCustomer(request.getHeader("ID"));

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customer", produces = { "application/json" }, method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer() {
        log.info("Get customer");
        return new ResponseEntity<Customer>(customerService.getCustomerById(request.getHeader("ID")), HttpStatus.OK);
    }


    @RequestMapping(value = "/customer", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<String> newCustomer(@RequestBody Customer customer) {
        log.info("Post customer");
        return new ResponseEntity<String>(customer.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", consumes = { "application/json" }, method = RequestMethod.PATCH)
    public ResponseEntity<Void> patchCustomer(@RequestBody Customer customer) {
        log.info("Patch customer");
        customerService.updateCustomer(customer, request.getHeader("ID"));
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customer", consumes = { "application/json" }, method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer) {
        log.info("Put customer");
        customerService.updateCustomer(customer, request.getHeader("ID"));
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customer/upload", method = RequestMethod.POST)
    public ResponseEntity<Void> uploadCustomer() {
        return null;
    }
}
