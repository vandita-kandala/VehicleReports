import { Component } from '@angular/core';
import {TrackerService} from './tracker.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[TrackerService]
})
export class AppComponent {
  title = 'app';
}
