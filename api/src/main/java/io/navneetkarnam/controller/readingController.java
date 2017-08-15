package io.navneetkarnam.controller;

import io.navneetkarnam.entity.readings;
import io.navneetkarnam.services.readingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class readingController {


    @Autowired
    readingsService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<readings> listAll(){

        return service.listAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<readings> byVin(@PathVariable("vin") String carVin){
        return service.byVin(carVin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public readings create(@RequestBody readings reading){

        return service.create(reading);
    }


}
