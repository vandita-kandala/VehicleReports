package io.chaithanya.egen.service;

import io.chaithanya.egen.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle findByVin(String vin);
    List<Vehicle> saveAllVehicles(List<Vehicle> vehicles);
    List<Vehicle> getAllVehicles();
    Vehicle getByVin(String vin);

}
