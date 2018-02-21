import { Component, OnInit } from '@angular/core';
import {TrackerService} from '../tracker.service';
import {Vehicle} from './vehicle.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicles: Vehicle[];
  constructor(private trackerService: TrackerService, private router: Router) { }

  ngOnInit() {
      this.trackerService.getVehicles()
        .subscribe(vehicles => this.vehicles = vehicles,
                  error => console.log("error is "+ error));
  }

  onClickVehicle(vin: string) {
    this.router.navigate(['/vehicle', vin]);
  }
}
