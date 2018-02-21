package io.chaithanya.egen.repository;

import io.chaithanya.egen.entity.Readings;

public interface ReadingRepository {
    Readings findByVin(String vin);
    Readings SaveReading(Readings readings);
    Readings updateReading(Readings readings);
    Readings getReadingByVin(String vin);
}
