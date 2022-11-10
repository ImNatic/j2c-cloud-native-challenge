package com.miguelfnunes.challenge.service;

import com.miguelfnunes.challenge.exception.IDNotFound;
import com.miguelfnunes.challenge.exception.InvalidID;
import com.miguelfnunes.challenge.model.Activity;
import com.miguelfnunes.challenge.model.Customer;
import com.miguelfnunes.challenge.repository.ActivityRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Log4j
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity getActivityById(String id) {
        if(id.isEmpty()){
            log.debug("ID Not Found");
            throw new IDNotFound();
        }else {
            Optional<Activity> optional = activityRepository.findById(id);
            Activity activity = null;
            if (optional.isPresent()) {
                activity = optional.get();
            } else {
                log.debug("Invalid ID");
                throw new InvalidID();
            }
            return activity;
        }
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
}
