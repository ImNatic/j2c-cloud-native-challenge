package com.miguelfnunes.challenge.repository;

import com.miguelfnunes.challenge.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, String> {
    //List<Scheduling> findAllBycustomer_id(String customer_id);
}
