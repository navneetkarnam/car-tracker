package io.navneetkarnam.services;

import io.navneetkarnam.entity.vehicle;
import io.navneetkarnam.exception.BadRequestException;
import io.navneetkarnam.exception.ResourceNotFoundException;
import io.navneetkarnam.repository.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class vehicleServiceImpl implements vehicleService{

    @Autowired
    vehicleRepository repository;


    @Transactional(readOnly = true)
    public List<vehicle> findAll() {

        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public vehicle findByVin(String carVin) {

        vehicle exists = repository.findByVin(carVin);
        if (exists == null){
            //throw exception "Resource Not found"
            throw new ResourceNotFoundException("The car with vin: " +carVin+ "does not exist");
        }
        return exists;
    }

    @Transactional
    public vehicle create(vehicle car) {

        vehicle exists = repository.findByVin(car.getVin());
        if(exists != null){
            //throw exception "Bad Request"
            throw new BadRequestException("The car with vin: " + car.getVin() + " already exists!");
        }
        return repository.create(car);
    }

    @Transactional
    public List<vehicle> update(List<vehicle> cars) {

        for(vehicle car: cars){

            vehicle exists = repository.findByVin(car.getVin());

            if(exists == null){
                repository.create(car);
            }
            else {
                repository.update(car);

            }
        }

        return cars;

    }

    @Transactional
    public void delete(String carVin) {

        vehicle exists = repository.findByVin(carVin);
        if(exists == null){
            //throw exception "Resource Not found"
            throw new ResourceNotFoundException("The car with vin: " +carVin+ "does not exist");
        }

        repository.delete(exists);

    }
}
