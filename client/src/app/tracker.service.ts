import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Reading} from './vehicles/vehicle/readings.model';
import {Tire} from './vehicles/vehicle/tire.model';
import {PriorityModel} from './vehicles/report/priority.model';

@Injectable()
export class TrackerService {

  allPriorities : PriorityModel[] = [];

  constructor(private http: Http) {}

  getAllHightAlerts(){
    const newList : PriorityModel[] = [];
    for (const priority of  this.allPriorities) {
      if (priority.priority === 'HIGH') {
        newList.push(priority);
      }
    }
    return newList;
  }
  getAllMedAlerts(){
    const newList : PriorityModel[] = [];
    for (const priority of  this.allPriorities) {
      if (priority.priority === 'MEDIUM') {
        newList.push(priority);
      }
    }
    return newList;
  }
  getAllLowtAlerts(){
    const newList : PriorityModel[] = [];
    for (const priority of  this.allPriorities) {
      if (priority.priority === 'LOW') {
        newList.push(priority);
      }
    }
    return newList;
  }

  getHighAlertsTwoHours() {
    return this.http.get('http://localhost:8080/api/priority')
      .map((response: any) => {
        const data = response.json();
        const transformedPriority: PriorityModel[] = [];
        for (let priority of data) {
          transformedPriority.push( new PriorityModel(priority.vin, priority.priority, priority.message, priority.timestamp));
        }
        this.allPriorities = transformedPriority;
        return transformedPriority;
      })
      .catch(error => Observable.throw(error.statusText));
  }

  getVehicles() {
    return this.http.get('http://localhost:8080/api/vehicles')
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  getHighAlertVehicles() {
    return this.http.get('http://localhost:8080/api/priority')
      .map((response: any) => {
        const data = response.json();
        for (let priority of data) {
          this.allPriorities.push( new PriorityModel(priority.vin, priority.priority, priority.message, priority.timestamp));
        }
        return this.allPriorities;
      })
      .catch(error => Observable.throw(error.statusText));
  }

  getVehicleByVin(vin: string) {
    return this.http.get('http://localhost:8080/api/readings/'+vin)
      .map((response:any) => {
        const data = response.json();
        const tire = new Tire(data.tires.frontLeft, data.tires.frontRight, data.tires.rearLeft, data.tires.rearRight);
        console.log(tire);

        const readings = new Reading(data.vin, data.latitude, data.longitude, data.timestamp, data.fuelVolume, data.speed, data.engineHp, data.checkEngineLightOn, data.engineCoolantLow, data.cruiseControlOn, data.engineRpm, tire);
        return readings;
      })
      .catch(error => Observable.throw(error.statusText));
  }


  getReportByVin(vin: string) {

    return this.http.get('http://localhost:8080/api/priority/'+vin)
      .map((response: any) => {
        const data = response.json();
        const transformedPriority: PriorityModel[] = [];
        for (let priority of data) {
          transformedPriority.push( new PriorityModel(priority.vin, priority.priority, priority.message, priority.timestamp));
        }
        return transformedPriority;
      })
      .catch(error => Observable.throw(error.statusText));
  }



}
