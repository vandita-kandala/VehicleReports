import {Component, Input, OnInit} from '@angular/core';
import {TrackerService} from '../../tracker.service';
import {PriorityModel} from './priority.model';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  @Input() vin: string;

  sortByTimeAsc: boolean;
  sortByPriorityAsc: boolean;

  priroities : PriorityModel[];

  constructor(private trackerService: TrackerService) { }

  ngOnInit() {
    this.trackerService.getReportByVin(this.vin)
      .subscribe( priorities => this.priroities = priorities,
                error => console.log(error));
  }

  onclicktime() {
    this.priroities.sort(
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
