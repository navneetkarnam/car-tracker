package io.navneetkarnam.services;

import io.navneetkarnam.entity.readings;

import java.util.List;

public interface readingsService {

    List<readings> listAll();

    List<readings> byVin(String carVin);

    readings create(readings reading);


}
