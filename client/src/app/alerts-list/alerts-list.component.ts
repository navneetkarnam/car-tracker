import { Component, OnInit } from '@angular/core';
import {AlertsService} from "../alerts-service/alerts.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-alerts-list',
  templateUrl: './alerts-list.component.html',
  styleUrls: ['./alerts-list.component.css']
})
export class AlertsListComponent implements OnInit{
  alerts;
  highNumber = 0;
  constructor(private route: ActivatedRoute, private alertsService: AlertsService) {
  }
  count() {
    this.highNumber += 1;
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.alertsService.getAlertsByVin(params.id)
        .subscribe(alerts => this.alerts = alerts);
    });
  }


}
