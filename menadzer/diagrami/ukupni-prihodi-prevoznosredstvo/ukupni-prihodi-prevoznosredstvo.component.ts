import { Component, OnInit } from '@angular/core';
import { AgCharts } from 'ag-charts-angular';
import { AgChartOptions } from 'ag-charts-community';

@Component({
  selector: 'app-ukupni-prihodi-prevoznosredstvo',
  standalone: true,
  imports: [AgCharts],
  templateUrl: './ukupni-prihodi-prevoznosredstvo.component.html',
  styleUrl: './ukupni-prihodi-prevoznosredstvo.component.css'
})
export class UkupniPrihodiPrevoznosredstvoComponent implements OnInit {
    public chartOptions: AgChartOptions = {};

    constructor() {
      /*this.chartOptions = {
        data: [
          { prevoznoSredstvo: 'Automobil',  ukupanPrihod: 4500 },
          { prevoznoSredstvo: 'Elektricni bicikl',  ukupanPrihod: 1100 },
          { prevoznoSredstvo: 'Elektricni trotinet',  ukupanPrihod: 1600 },
          
        ],
        // Series: Defines which chart type and data to use
        series: [{ type: 'bar', xKey: 'prevoznoSredstvo', yKey: 'ukupanPrihod' }]
      };*/
  }

  ngOnInit(): void {
    this.chartOptions = {
      data: [
        { prevoznoSredstvo: 'Automobil',  ukupanPrihod: 4500 },
        { prevoznoSredstvo: 'Elektricni bicikl',  ukupanPrihod: 1100 },
        { prevoznoSredstvo: 'Elektricni trotinet',  ukupanPrihod: 1600 },
        
      ],
      // Series: Defines which chart type and data to use
      series: [{ type: 'area', xKey: 'prevoznoSredstvo', yKey: 'ukupanPrihod' }]
    };
  }
}
