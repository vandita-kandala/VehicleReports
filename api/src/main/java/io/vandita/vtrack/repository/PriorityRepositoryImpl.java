package io.chaithanya.egen.repository;

import io.chaithanya.egen.entity.Priority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PriorityRepositoryImpl  implements PriorityRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public Priority savePriority(Priority priority) {

        entityManager.persist(priority);
        return priority;
    }

    public List<Priority> getAllHighLast2Hous() {
        TypedQuery<Priority> query  = entityManager.createNamedQuery("Priority.getAllAlerts", Priority.class);

//        Timestamp orderTime = new Timestamp(System.currentTimeMillis() - 3 * 60L * 60L * 1000L);
//        query.setParameter("time", orderTime);

        return query.getResultList();
    }

    public List<Priority> getReportByVin(String vin) {
        TypedQuery<Priority> query = entityManager.createNamedQuery("Priority.getByVin", Priority.class);
        query.setParameter("paramVin", vin);
        List<Priority> resultList = query.getResultList();
        for(Priority p: resultList)
                System.out.print(p);

        return  resultList;
    }
}
