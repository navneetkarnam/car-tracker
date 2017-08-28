import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ClientLandingComponent } from './client-landing/client-landing.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpModule} from "@angular/http";
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import {VehicleService} from "./vehicle-service/vehicle.service";
import { ReadingsListComponent } from './readings-list/readings-list.component';
import {ReadingService} from "./reading-service/reading.service";
import { AlertsListComponent } from './alerts-list/alerts-list.component';
import {AlertsService} from "./alerts-service/alerts.service";
import { AgmCoreModule } from '@agm/core';
import { ChartsModule } from 'ng2-charts';


const trackerRoutes: Routes = [
      {path: 'home', component: ClientLandingComponent},
      {path: 'vehicles', component: VehicleListComponent},
      {path: 'readings/:id', component: ReadingsListComponent},
      {path: 'alerts/:id', component: AlertsListComponent},
      {path: '', redirectTo: '/home', pathMatch: 'full'}
];


@NgModule({
  declarations: [
    AppComponent,
    ClientLandingComponent,
    VehicleListComponent,
    ReadingsListComponent,
    AlertsListComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ChartsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAPG3WALYgbB9ArnlkWWVW1oRYNMMmWhOA'
    }),
    RouterModule.forRoot(trackerRoutes)
  ],
  providers: [VehicleService, ReadingService, AlertsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
