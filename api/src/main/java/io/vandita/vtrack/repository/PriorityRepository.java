package io.chaithanya.egen.repository;

import io.chaithanya.egen.entity.Priority;

import java.util.List;

public interface PriorityRepository {

    Priority savePriority(Priority priority);

    List<Priority> getAllHighLast2Hous();

    List<Priority> getReportByVin(String vin);
}
