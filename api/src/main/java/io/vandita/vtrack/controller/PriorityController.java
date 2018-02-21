package io.chaithanya.egen.controller;


import io.chaithanya.egen.entity.Priority;
import io.chaithanya.egen.entity.Vehicle;
import io.chaithanya.egen.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/priority")
public class PriorityController {

    @Autowired
    PriorityService priorityService;

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Priority> getAllVehicles(){
        return priorityService.getAllHighLast2Hous();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{vin}")
    public List<Priority> allReportsByVin(@PathVariable String vin){
            return priorityService.getReportByVin(vin);
    };

}
