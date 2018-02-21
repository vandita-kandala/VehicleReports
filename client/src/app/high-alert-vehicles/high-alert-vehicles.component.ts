import { Component, OnInit } from '@angular/core';
import {Vehicle} from '../vehicles/vehicle.model';
import {TrackerService} from '../tracker.service';
import {PriorityVehicles} from './priority.model';

@Component({
  selector: 'app-high-alert-vehicles',
  templateUrl: './high-alert-vehicles.component.html',
  styleUrls: ['./high-alert-vehicles.component.css']
})
export class HighAlertVehiclesComponent implements OnInit {

  priorityVehicles: PriorityVehicles[];

  constructor(private trackerService: TrackerService) { }

  ngOnInit() {
      this.trackerService.getHighAlertVehicles()
        .subscribe(
          vehicles => this.priorityVehicles = vehicles,
          error => console.log(error)
        );
  }

}
