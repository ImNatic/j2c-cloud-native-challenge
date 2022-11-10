package com.miguelfnunes.challenge.service;

import com.miguelfnunes.challenge.exception.IDNotFound;
import com.miguelfnunes.challenge.exception.InvalidID;
import com.miguelfnunes.challenge.model.Customer;
import com.miguelfnunes.challenge.repository.CustomerRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Log4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomer(String id) {
        if(id.isEmpty()){
            log.debug("ID Not Found");
            throw new IDNotFound();
        }else if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        } else {
            log.debug("Invalid ID");
            throw new InvalidID();
        }
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        if(id.isEmpty()){
            log.debug("ID Not Found");
            throw new IDNotFound();
        }else {
            Optional<Customer> optional = customerRepository.findById(id);
            Customer customer = null;
            if (optional.isPresent()) {
                customer = optional.get();
            } else {
                log.debug("Invalid ID");
                throw new InvalidID();
            }
            return customer;
        }
    }

    public void updateCustomer(Customer newCustomer, String id) {
        if(id.isEmpty()) {
            log.debug("ID Not Found");
            throw new IDNotFound();
        }else {
                Optional<Customer> optional = customerRepository.findById(id);
                if (optional.isPresent()) {
                    Customer customer = optional.get();

                    if (newCustomer.getFirst_name() != null)
                        customer.setFirst_name(newCustomer.getFirst_name());
                    if (newCustomer.getLast_name() != null)
                        customer.setLast_name(newCustomer.getLast_name());
                    if (newCustomer.getBirthdate() != null)
                        customer.setBirthdate(newCustomer.getBirthdate());
                    if (newCustomer.getFiscal_number() != null)
                        customer.setFiscal_number(newCustomer.getFiscal_number());
                    if (newCustomer.getMobile_number() != null)
                        customer.setMobile_number(newCustomer.getMobile_number());
                } else {
                    log.debug("Invalid ID");
                    throw new InvalidID();
                }
            }
    }
}
