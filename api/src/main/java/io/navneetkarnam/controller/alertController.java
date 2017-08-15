package io.navneetkarnam.controller;

import io.navneetkarnam.entity.alerts;
import io.navneetkarnam.services.alertServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/alerts")
public class alertController {

    @Autowired
    alertServices services;

    //All Alerts
    @RequestMapping(method = RequestMethod.GET)
    public List<alerts> alertsList(){
        return services.alertsList();
    }

    //Alerts by Vin
    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<alerts> alertByVin(@PathVariable("vin") String carVin){
        return services.alertByVin(carVin);
    }


    //List of High Alerts for all Vehicles
    @RequestMapping(method = RequestMethod.GET, value = "/highAlerts")
    public List<alerts> alertHigh() {
        return services.alertHigh();
    }


    //List of High Alerts by Vin number
    @RequestMapping(method = RequestMethod.GET, value = "/highAlerts/{vin}")
    public List<alerts> highByVin(@PathVariable("vin") String carVin) {
        return services.highByVin(carVin);
    }

}
