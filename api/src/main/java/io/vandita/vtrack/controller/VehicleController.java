package io.chaithanya.egen.controller;

import io.chaithanya.egen.entity.Vehicle;
import io.chaithanya.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Component
//@ResponseBody

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method= RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> saveAllVehicles(@RequestBody List<Vehicle> vehicles){

        return vehicleService.saveAllVehicles(vehicles);
    }

    @RequestMapping(method=RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle getVehicleByVin(@PathVariable("vin") String vin){

        return vehicleService.getByVin(vin);
    }

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }



}
