import { Component, OnInit } from '@angular/core';
import {ReadingService} from "../reading-service/reading.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-readings-list',
  templateUrl: './readings-list.component.html',
  styleUrls: ['./readings-list.component.css']
})
export class ReadingsListComponent implements OnInit{
  lat = 41.7476;
  lng = -74.0868;
  readings;
  speedData = [];
  fuelData = [];
  rpmData = [];
  timeData = [];
  constructor(private route: ActivatedRoute, private readingsService: ReadingService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.readingsService.getReadings(params.id)
        .subscribe(readings => this.readings = readings);
    });
  }

  location(latitude, longitude) {
    this.lat = latitude;
    this.lng = longitude;
  }
  plotSpeed(currentSpeed) {
    this.speedData.push(currentSpeed);
  }
  plotFuel(currentFuel) {
    this.fuelData.push(currentFuel);
  }
  plotRpm(currentRpm) {
    this.rpmData.push(currentRpm);
  }
  plotTime(currentTime) {
   this.timeData.push(currentTime);
  }

  public barChartOptions:any = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels:string[] = new Array(15);
  public barChartType:string = 'bar';
  public barChartLegend:boolean = true;

  public barChartData:any[] = [
    {data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], label: 'SPEED (mph)'}
  ];

  public barChartColors: Array<any> = [
    {
      backgroundColor: '#183649',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroudColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#ffa91b',
      pointHoverBackgroundColor: '#ffdb15',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ]
  public barChartData1:any[] = [
    {data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], label: 'FUEL VOLUME (Gallons)'}
  ];

  public barChartColors1: Array<any> = [
    {
      backgroundColor: '#3f4007',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroudColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#ffa91b',
      pointHoverBackgroundColor: '#ffdb15',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ]
  public barChartData2:any[] = [
    {data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], label: 'ENGINE RPM'}
  ];
  public barChartColors2: Array<any> = [
    {
      backgroundColor: '#3e1d00',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroudColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#ffa91b',
      pointHoverBackgroundColor: '#ffdb15',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ]
  // events
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }

  public label(){
    for(let i = 0; i< this.barChartLabels.length; i++){
      this.barChartLabels[i] = this.timeData[i];
    }
  }
  public getSpeed():void {
    // Only Change 3 values
    this.label();
    let data = this.speedData;
    let clone = JSON.parse(JSON.stringify(this.barChartData));
    clone[0].data = data;
    this.barChartData = clone;

  }

  public getFuel():void {
    // Only Change 3 values
    this.label();
    let data = this.fuelData;
    let clone = JSON.parse(JSON.stringify(this.barChartData1));
    clone[0].data = data;
    this.barChartData1 = clone;

  }

  public getRpm():void {
    // Only Change 3 values
    this.label();
    let data = this.rpmData;
    let clone = JSON.parse(JSON.stringify(this.barChartData2));
    clone[0].data = data;
    this.barChartData2 = clone;

  }

  public getGraphs(): void{
    this.getSpeed();
    this.getFuel();
    this.getRpm();
  }
}
