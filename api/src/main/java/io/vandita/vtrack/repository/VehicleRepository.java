package io.chaithanya.egen.repository;

import io.chaithanya.egen.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle findByVin(String vin);
    Vehicle saveVehicle(Vehicle vehicles);
    Vehicle updateVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();
    Vehicle getByVin(String vin);
}
