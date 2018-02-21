package io.chaithanya.egen.repository;

import io.chaithanya.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Vehicle findByVin(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }


    public List<Vehicle> getAllVehicles() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.getAll", Vehicle.class );
        return query.getResultList();
    }

    public Vehicle getByVin(String vin) {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.getByVin", Vehicle.class);
        query.setParameter("paramVin", vin);
        List<Vehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }


}
