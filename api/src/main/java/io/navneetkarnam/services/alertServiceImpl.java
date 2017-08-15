package io.navneetkarnam.services;

import io.navneetkarnam.entity.alerts;
import io.navneetkarnam.exception.ResourceNotFoundException;
import io.navneetkarnam.repository.alertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class alertServiceImpl implements alertServices {

    @Autowired
    alertRepository alertRepository;

    @Transactional
    public List<alerts> alertsList() {
        return alertRepository.alertsList();
    }

    @Transactional
    public List<alerts> alertByVin(String carVin) {
        List<alerts> exists = alertRepository.alertByVin(carVin);
        if (exists == null) {
            //throw "Resource not found" exception
            throw new ResourceNotFoundException("The car with Vin: " +carVin+ " does not exist!");
        }
        return exists;
    }

    @Transactional
    public List<alerts> alertHigh() {

        return alertRepository.alertHigh();
    }

    @Transactional
    public List<alerts> highByVin(String carVin){
        List<alerts> exists = alertRepository.highByVin(carVin);
        if (exists == null) {
            //throw "Resource not found" exception
            throw new ResourceNotFoundException("The car with Vin: " +carVin+ " does not have any HIGH alerts!");
        }
        return exists;
    }

    @Transactional
    public alerts create(alerts alert) {
        return alertRepository.create(alert);
    }
}
