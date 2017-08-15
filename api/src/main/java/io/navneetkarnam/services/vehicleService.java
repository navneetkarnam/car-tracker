package io.navneetkarnam.services;

import io.navneetkarnam.entity.vehicle;

import java.util.List;

public interface vehicleService {

    List<vehicle> findAll();

    vehicle findByVin(String carVin);

    vehicle create(vehicle car);

    List<vehicle> update(List<vehicle> cars);

    void delete(String carVin);
}
