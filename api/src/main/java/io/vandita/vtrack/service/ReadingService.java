package io.chaithanya.egen.service;


import io.chaithanya.egen.entity.Readings;

public interface ReadingService {

    Readings findByVin(String vin);
    Readings SaveReading(Readings readings);
    Readings getReadingByVin(String vin);
}
