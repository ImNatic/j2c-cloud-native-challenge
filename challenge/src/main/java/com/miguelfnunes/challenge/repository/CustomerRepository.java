package com.miguelfnunes.challenge.repository;

import com.miguelfnunes.challenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, java.lang.String> {
}
