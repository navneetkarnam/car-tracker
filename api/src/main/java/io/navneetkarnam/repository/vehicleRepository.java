package io.navneetkarnam.repository;

import io.navneetkarnam.entity.vehicle;

import java.util.List;

public interface vehicleRepository {


    List<vehicle> findAll();

    vehicle findByVin(String carVin);

    vehicle create(vehicle car);

    vehicle update(vehicle car);

    void delete(vehicle car);

}
