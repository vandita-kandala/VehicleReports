import { Component, OnInit } from '@angular/core';
import {TrackerService} from '../tracker.service';
import {PriorityModel} from '../vehicles/report/priority.model';

@Component({
  selector: 'app-high-alerts',
  templateUrl: './high-alerts.component.html',
  styleUrls: ['./high-alerts.component.css']
})
export class HighAlertsComponent implements OnInit {

  allPriorities : PriorityModel[];
  sortByTimeAsc: boolean;
  count : number;

  constructor(private trackerService: TrackerService) { }

  ngOnInit() {
  this.allPriorities =   this.trackerService.getAllHightAlerts();
  this.count = this.allPriorities.length;
  }


  onclicktime() {
    this.allPriorities.sort(
      (p1,p2) => {
        if ( p1.timestamp < p2.timestamp){
          return this.sortByTimeAsc === true ? -1 : 1;
        } else if ( p1.timestamp > p2.timestamp) {
          return this.sortByTimeAsc === true ? 1 : -1;
        } else {
          return 0;
        }
      });

    this.sortByTimeAsc = this.sortByTimeAsc!==true;

  }

}
