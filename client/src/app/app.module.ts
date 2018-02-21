import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AgmCoreModule} from '@agm/core';


import { AppComponent } from './app.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import {HttpModule} from '@angular/http';
import { HighAlertVehiclesComponent } from './high-alert-vehicles/high-alert-vehicles.component';
import { VehicleComponent } from './vehicles/vehicle/vehicle.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import {routing} from './app.routing';
import { ReportComponent } from './vehicles/report/report.component';
import { HighAlertsComponent } from './high-alerts/high-alerts.component';
import { MediumAlertsComponent } from './medium-alerts/medium-alerts.component';
import { LowAlertsComponent } from './low-alerts/low-alerts.component';


@NgModule({
  declarations: [
    AppComponent,
    VehiclesComponent,
    HighAlertVehiclesComponent,
    VehicleComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    ReportComponent,
    HighAlertsComponent,
    MediumAlertsComponent,
    LowAlertsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    routing,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCCOpq7Q5p9Aj2p6OvQZmfMU1uqshvwpzA'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
