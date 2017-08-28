import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AlertsService {

  constructor(private http: Http) { }


  getAlertsByVin(vehicleVin): Observable<any[]> {
    return this.http.get(`http://localhost:8080/alerts/${vehicleVin}`, vehicleVin)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
}
