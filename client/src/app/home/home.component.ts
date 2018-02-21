import { Component, OnInit } from '@angular/core';
import {TrackerService} from '../tracker.service';
import {PriorityModel} from '../vehicles/report/priority.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  high:number;
  medium:number;
  low:number;

  constructor(private trackService: TrackerService) { }

  ngOnInit() {
    this.high=0;this.low=0;this.medium=0;
    this.trackService.getHighAlertsTwoHours()
      .subscribe(
        priorities => {
          for (const priority of  priorities) {
            if (priority.priority === 'HIGH') {
              this.high++;
            }else if(priority.priority === 'MEDIUM'){
              this.medium++;
            }else if(priority.priority === 'LOW'){
              this.low++;
            }
          }
        },
        error => console.error(error)
      );
  }

}
