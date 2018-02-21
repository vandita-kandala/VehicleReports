import { Component, OnInit } from '@angular/core';
import {TrackerService} from '../../tracker.service';
import {Reading} from './readings.model';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  readings: Reading;
  constructor(private trackerService:TrackerService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.trackerService.getVehicleByVin(this.router.snapshot.paramMap.get('vin'))
      .subscribe(readings => {
        this.readings = readings;
        this.lat = readings.latitude;
        this.lng = readings.longitude;
        console.log(readings);
      });
  }
  lat: number ;
  lng: number ;

}
