package io.chaithanya.egen.controller;

import io.chaithanya.egen.entity.Readings;
import io.chaithanya.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/readings")
public class ReadingsController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST)
    public Readings saveReadings(@RequestBody Readings readings){
        return readingService.SaveReading(readings);
    }

    @RequestMapping(method = RequestMethod.GET, value="{vin}")
    public Readings getReadingByVin(@PathVariable("vin") String vin){
        return readingService.getReadingByVin(vin);
    }
}
