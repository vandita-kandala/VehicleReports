package io.chaithanya.egen.service;

import io.chaithanya.egen.entity.Priority;
import io.chaithanya.egen.entity.Readings;
import io.chaithanya.egen.entity.Vehicle;
import io.chaithanya.egen.repository.PriorityRepository;
import io.chaithanya.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    PriorityRepository priorityRepository;

    public Readings findByVin(String vin) {
        return readingRepository.findByVin(vin);
    }

    @Transactional
    public Readings SaveReading(Readings readings) {

        Vehicle vehicle = vehicleService.findByVin(readings.getVin());

        if (vehicle != null) {

            //save the priority. . .
            Priority priority;

            //Checking rule 1
            int readLineRpm = vehicle.getReadlineRpm();
            int engineRpm = readings.getEngineRpm();
            if(engineRpm > readLineRpm){
                priority = new Priority(vehicle.getVin(), "HIGH", "Engine RPM is greater than Readline RPM", readings.getTimestamp());
                priorityRepository.savePriority(priority);
            }

            //checking Rule 2
            float fuelVolume = readings.getFuelVolume();
            int maxFuelVolume = vehicle.getMaxFuelVolume();
            if(fuelVolume < (0.1*maxFuelVolume)){
                priority = new Priority(vehicle.getVin(), "MEDIUM", "Fuel volume is less than ten percent of maximum  fuel volume", readings.getTimestamp());
                priorityRepository.savePriority(priority);
            }

            //checking rule 3:
            int frontLeft = readings.getTires().getFrontLeft();
            int frontRight = readings.getTires().getFrontRight();
            int rearLeft = readings.getTires().getRearLeft();
            int rearRight  = readings.getTires().getRearRight();

            if( (frontLeft < 32 || frontLeft > 36)  ||
                    (frontRight < 32 || frontRight > 36) ||
                    (rearLeft < 32 || rearLeft > 36) ||
                    (rearRight < 32 || rearRight > 36) ){
                priority = new Priority(vehicle.getVin(), "LOW", "Tire pressure of any of the tires is less than 32psi or is greater than 36psi", readings.getTimestamp());
                priorityRepository.savePriority(priority);
            }


            //Checking rule 4
            boolean enginecoolant = readings.isEngineCoolantLow();
            boolean engineLights = readings.isCheckEngineLightOn();
            if(enginecoolant || engineLights){
                priority = new Priority(vehicle.getVin(), "LOW", "Either engine coolant is low or Engine light is on", readings.getTimestamp());
                priorityRepository.savePriority(priority);
            }


            //save the reading . . .
            if (readingRepository.findByVin((readings.getVin())) == null) {
                return readingRepository.SaveReading(readings);
            } else
                return readingRepository.updateReading(readings);
        }

        return null;
    }

    public Readings getReadingByVin(String vin) {
        return readingRepository.getReadingByVin(vin);
    }
}
