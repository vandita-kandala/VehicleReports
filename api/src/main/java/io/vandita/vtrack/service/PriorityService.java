package io.chaithanya.egen.service;

import io.chaithanya.egen.entity.Priority;

import java.util.List;

public interface PriorityService {

    List<Priority> getAllHighLast2Hous();
    List<Priority> getReportByVin(String vin);
}
