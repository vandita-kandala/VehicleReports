package io.chaithanya.egen.service;

import io.chaithanya.egen.entity.Vehicle;
import io.chaithanya.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle findByVin(String vin) {
        return vehicleRepository.findByVin(vin);
    }

    @Transactional
    public List<Vehicle> saveAllVehicles(List<Vehicle> vehicles) {

        Vehicle v;
        List<Vehicle> vehs = new ArrayList<Vehicle>();

        for(Vehicle vehicle: vehicles){
            if(vehicleRepository.findByVin(vehicle.getVin()) == null){
                v = vehicleRepository.saveVehicle(vehicle);
            }else{
                v = vehicleRepository.updateVehicle(vehicle);
            }
            vehs.add(v);
        }

        return vehs;

    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.getAllVehicles();
    }

    public Vehicle getByVin(String vin) {
        return vehicleRepository.getByVin(vin);
    }
}
