import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {VehicleComponent} from './vehicles/vehicle/vehicle.component';
import {HighAlertsComponent} from './high-alerts/high-alerts.component';
import {MediumAlertsComponent} from './medium-alerts/medium-alerts.component';
import {LowAlertsComponent} from './low-alerts/low-alerts.component';

const APP_ROUTING: Routes = [
  {path: '', redirectTo: '/home', pathMatch:'full'},
  {path: 'home', component: HomeComponent},
  {path: 'vehicle/:vin', component: VehicleComponent},
  {path: 'highAlerts', component: HighAlertsComponent},
  {path: 'mediumAlerts', component: MediumAlertsComponent},
  {path: 'lowAlerts', component: LowAlertsComponent}
];


export const routing = RouterModule.forRoot(APP_ROUTING);
