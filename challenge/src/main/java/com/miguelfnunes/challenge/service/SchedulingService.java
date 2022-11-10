package com.miguelfnunes.challenge.service;

import com.miguelfnunes.challenge.model.Scheduling;

import java.util.List;

public interface SchedulingService {

    List<Scheduling> getSchedulingByCustomerId(String id);
    Scheduling getSchedulingById(String id);
    void deleteSchedulingById(String id);
}
