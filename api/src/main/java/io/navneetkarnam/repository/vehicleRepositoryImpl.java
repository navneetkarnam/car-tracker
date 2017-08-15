package io.navneetkarnam.repository;

import io.navneetkarnam.entity.vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class vehicleRepositoryImpl implements vehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<vehicle> findAll()
    {
        TypedQuery<vehicle> query = entityManager.createNamedQuery("vehicle.findAll", vehicle.class);

        return query.getResultList();
    }


    public vehicle findByVin(String carVin) {

        return entityManager.find(vehicle.class, carVin);
    }


    public vehicle create(vehicle car) {

        entityManager.persist(car);
        return car;

    }


    public vehicle update(vehicle car) {

        entityManager.merge(car);
        return car;
    }


    public void delete(vehicle car) {

        entityManager.remove(car);

    }
}
