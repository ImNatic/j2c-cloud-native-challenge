package com.miguelfnunes.challenge.service;

import com.miguelfnunes.challenge.model.Customer;

public interface CustomerService {

    void deleteCustomer(String id);
    Customer saveCustomer(Customer customer);

    Customer getCustomerById(String id);

    void updateCustomer(Customer customer, String id);
}
