package io.navneetkarnam.services;

import io.navneetkarnam.entity.alerts;
import io.navneetkarnam.entity.readings;
import io.navneetkarnam.entity.vehicle;
import io.navneetkarnam.exception.ResourceNotFoundException;
import io.navneetkarnam.repository.alertRepository;
import io.navneetkarnam.repository.readingsRepository;
import io.navneetkarnam.repository.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class readingsServiceImpl implements readingsService {

    @Autowired
    alertRepository alertRepository;

    @Autowired
    vehicleRepository vehicleRepository;

    @Autowired
    readingsRepository repository;

    @Transactional(readOnly = true)
    public List<readings> listAll() {

        return repository.listAll();
    }


    @Transactional
    public List<readings> byVin(String carVin) {

        List<readings> exists = repository.byVin(carVin);
        if(exists == null){
            //throw exception "Resource not found"
            throw new ResourceNotFoundException("The car with Vin: " +carVin+ " does not exist!");

        }
        else {
            return exists;
        }

    }

    @Transactional
    public readings create(readings reading) {

        Optional<vehicle> cur = Optional.ofNullable(vehicleRepository.findByVin(reading.getVin()));

        cur.ifPresent(car ->{
            createAlert(reading, car);
        } );

        return repository.create(reading);
    }

    public void createAlert(readings reading, vehicle car){
        if(reading.getEngineRpm() > car.getRedlineRpm()){
            alerts alert = new alerts(car.getVin(), "EngineRPM", "HIGH", reading.getTimestamp());
            alertRepository.create(alert);
        }
        if(reading.getFuelVolume() < ((0.1) * car.getMaxFuelVolume() )){
            alerts alert = new alerts(car.getVin(), "Fuel Volume Low", "MEDIUM", reading.getTimestamp());
            alertRepository.create(alert);
        }
        if(reading.getTires().getFrontLeft() < 32 || reading.getTires().getFrontLeft() > 36 ||
                reading.getTires().getFrontRight() < 32 || reading.getTires().getFrontRight() > 36 ||
                reading.getTires().getRearLeft() < 32 || reading.getTires().getRearLeft() > 36 ||
                reading.getTires().getRearRight() < 32 || reading.getTires().getRearRight() > 36)
        {

            alerts alert = new alerts(car.getVin(), "Tire Pressure", "LOW", reading.getTimestamp());
            alertRepository.create(alert);

        }

        if(reading.getEngineCoolantLow() == true || reading.getCheckEngineLightOn() == true){
            alerts alert = new alerts(car.getVin(), "Engine coolant/ Engine Light", "LOW", reading.getTimestamp());
            alertRepository.create(alert);
        }
    }
}
