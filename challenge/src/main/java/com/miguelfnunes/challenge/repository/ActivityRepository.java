package com.miguelfnunes.challenge.repository;

import com.miguelfnunes.challenge.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, java.lang.String> {
}
