package com.miguelfnunes.challenge.service;

import com.miguelfnunes.challenge.model.Activity;

import java.util.List;

public interface ActivityService {

    Activity getActivityById(String id);
    List<Activity> getAllActivities();
}
