import { Component, OnInit } from '@angular/core';
import { AgCharts } from 'ag-charts-angular';
import { AgChartOptions } from 'ag-charts-community';

@Component({
  selector: 'app-broj-kvarova-po-prevoznomsredstvu',
  standalone: true,
  imports: [AgCharts],
  templateUrl: './broj-kvarova-po-prevoznomsredstvu.component.html',
  styleUrl: './broj-kvarova-po-prevoznomsredstvu.component.css'
})
export class BrojKvarovaPoPrevoznomsredstvuComponent implements OnInit {
  /*options = {
    title: {
      text: 'Simple Chart',
    },
    data: [
      { label: 'A', value: 50 },
      { label: 'B', value: 70 },
      { label: 'C', value: 30 },
    ],
    series: [
      {
        type: 'bar',
        xKey: 'label',
        yKey: 'value',
      },
    ],
  };*/
  public chartOptions: AgChartOptions = {};

  constructor() {
    /*this.chartOptions = {
      data: [
        { prevoznoSredstvo: 'Automobil',  brojKvarova: 7 },
        { prevoznoSredstvo: 'Elektricni bicikl',  brojKvarova: 2 },
        { prevoznoSredstvo: 'Elektricni trotinet',  brojKvarova: 4 },
        
      ],
      // Series: Defines which chart type and data to use
      series: [{ type: 'bar', xKey: 'prevoznoSredstvo', yKey: 'brojKvarova' }]
    };

   /* example data: [
      { prevoznoSredstvo: 'Automobil',  brojKvarova: 7 },
      { prevoznoSredstvo: 'Elektricni bicikl',  brojKvarova: 2 },
      { prevoznoSredstvo: 'Elektricni trotinet',  brojKvarova: 4 },
      
    ],
    // Series: Defines which chart type and data to use
    series: [
    
    { type: 'bar', xKey: 'prevoznoSredstvo', yKey: 'brojKvarova' }] */ 
  }

  ngOnInit(): void {
    console.log("ngOnInit starts...");
    this.chartOptions = {
      data: [
        { prevoznoSredstvo: 'Automobil',  brojKvarova: 7 },
        { prevoznoSredstvo: 'Elektricni bicikl',  brojKvarova: 2 },
        { prevoznoSredstvo: 'Elektricni trotinet',  brojKvarova: 4 },
        
      ],
      // Series: Defines which chart type and data to use
      series: [{ type: 'bar', xKey: 'prevoznoSredstvo', yKey: 'brojKvarova' }]
    };
  }
}
