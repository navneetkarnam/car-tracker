package io.navneetkarnam.controller;

import io.navneetkarnam.entity.vehicle;
import io.navneetkarnam.services.vehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/vehicles")
public class vehicleController {

    @Autowired
    vehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<vehicle> findAll() {

        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public vehicle findByVin(@PathVariable("vin") String carVin) {
        return service.findByVin(carVin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public vehicle create(@RequestBody vehicle car) {

        return service.create(car);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<vehicle> update(@RequestBody List<vehicle> cars) {

        return service.update(cars);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String carVin) {

        service.delete(carVin);
    }



}
