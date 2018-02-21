package io.chaithanya.egen.service;

import io.chaithanya.egen.entity.Priority;
import io.chaithanya.egen.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    private PriorityRepository priorityRepository;

    public List<Priority> getAllHighLast2Hous() {
        return priorityRepository.getAllHighLast2Hous();
    }

    public List<Priority> getReportByVin(String vin) {
        return priorityRepository.getReportByVin(vin);
    }
}
