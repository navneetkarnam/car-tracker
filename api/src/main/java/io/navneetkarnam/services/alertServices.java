package io.navneetkarnam.services;

import io.navneetkarnam.entity.alerts;


import java.util.List;


public interface alertServices {

    List<alerts> alertsList();

    List<alerts> alertByVin(String carVin);

    List<alerts> alertHigh();

    List<alerts> highByVin(String carVin);

    alerts create(alerts alert);

}
