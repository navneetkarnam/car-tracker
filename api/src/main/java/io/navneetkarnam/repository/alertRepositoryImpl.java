package io.navneetkarnam.repository;


import io.navneetkarnam.entity.alerts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class alertRepositoryImpl implements alertRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<alerts> alertsList() {

        TypedQuery<alerts> query = entityManager.createNamedQuery("alerts.alertsList", alerts.class);
        List<alerts> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<alerts> alertByVin(String carVin) {

        TypedQuery<alerts> query = entityManager.createNamedQuery("alerts.alertsByVin", alerts.class);
        query.setParameter("paramVin", carVin);
        List<alerts> resultList = query.getResultList();

        if(resultList != null && resultList.size() >= 1){
            return resultList;
        }
        else {
            return null;
        }

    }

    @Override
    public List<alerts> alertHigh() {
        TypedQuery<alerts> query = entityManager.createNamedQuery("alerts.alertsHigh", alerts.class);
        List<alerts> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<alerts> highByVin(String carVin) {

        TypedQuery<alerts> query = entityManager.createNamedQuery("alerts.highByVin", alerts.class);
        query.setParameter("paramVin", carVin);
        List<alerts> resultList  = query.getResultList();

        if(resultList != null && resultList.size() >= 1){
            return resultList;
        }
        else {
            return null;
        }

    }

    @Override
    public alerts create(alerts alert) {

        entityManager.persist(alert);
        return alert;
    }
}
