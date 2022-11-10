package com.miguelfnunes.challenge.service;

import com.miguelfnunes.challenge.exception.IDNotFound;
import com.miguelfnunes.challenge.exception.InvalidID;
import com.miguelfnunes.challenge.model.Scheduling;
import com.miguelfnunes.challenge.repository.SchedulingRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Log4j
@Service
public class SchedulingServiceImpl implements SchedulingService {
    @Autowired
    private SchedulingRepository schedulingRepository;

    @Override
    public List<Scheduling> getSchedulingByCustomerId(String id) {
        if(id.isEmpty()){
            log.debug("ID Not Found");

            throw new IDNotFound();
        }else {
            List<Scheduling> list = schedulingRepository.findAll();
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).getCustomer_id().equals(id)) {
                    list.remove(i);
                }
            }
            if(list.size()==0){
                log.debug("ID Not Found");
                throw new InvalidID();
            }else {
                return list;
            }
        }
    }

    @Override
    public Scheduling getSchedulingById(String id) {
        if(id.isEmpty()){
            log.debug("ID Not Found");
            throw new IDNotFound();
        }else {
            Optional<Scheduling> optional = schedulingRepository.findById(id);
            Scheduling scheduling = null;
            if (optional.isPresent()) {
                scheduling = optional.get();
            } else {
                log.debug("Invalid ID");
                throw new InvalidID();
            }
            return scheduling;
        }
    }

    @Override
    public void deleteSchedulingById(String id) {
        if(id.isEmpty()){
            log.debug("ID Not Found");
            throw new IDNotFound();
        }else if (schedulingRepository.existsById(id)){
            schedulingRepository.deleteById(id);
        } else {
            log.debug("ID Not Found");
            throw new IDNotFound();
        }
    }
}
