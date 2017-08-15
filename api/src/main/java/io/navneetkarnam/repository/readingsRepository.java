package io.navneetkarnam.repository;

import io.navneetkarnam.entity.readings;

import java.util.List;

public interface readingsRepository {

    List<readings> listAll();

    List<readings> byVin(String carVin);

    readings create(readings reading);

}
