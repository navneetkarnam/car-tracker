package io.navneetkarnam.repository;

import io.navneetkarnam.entity.readings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class readingsRepositoryImpl implements readingsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<readings> listAll() {
        TypedQuery<readings> query = entityManager.createNamedQuery("readings.listAll", readings.class);
        return query.getResultList();
    }

    @Override
    public List<readings> byVin(String carVin) {
        TypedQuery<readings> query = entityManager.createNamedQuery("readings.byVin", readings.class);
        query.setParameter("paramVin", carVin);
        List<readings> resultList = query.getResultList();
        if(resultList != null && resultList.size() >= 1){
            return resultList;
        }
        else {
            return null;
        }
    }

    @Override
    public readings create(readings reading) {
        entityManager.persist(reading);
        return reading;
    }
}
