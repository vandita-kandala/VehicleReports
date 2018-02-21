package io.chaithanya.egen.repository;

import io.chaithanya.egen.entity.Readings;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Readings findByVin(String vin) {
        return entityManager.find(Readings.class, vin);
    }

    public Readings SaveReading(Readings readings) {
        entityManager.persist(readings);
        return readings;
    }

    public Readings updateReading(Readings readings) {
        return entityManager.merge(readings);
    }

    public Readings getReadingByVin(String vin) {
        TypedQuery<Readings> query = entityManager.createNamedQuery("Reading.getByVin", Readings.class);
        query.setParameter("paramVin", vin);
        List<Readings> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
