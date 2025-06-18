import { Component, OnInit } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Iznajmljivanje } from './model/iznajmljivanje';
import { map } from 'rxjs';
import { HttpService } from './service/http.service';
import { MatTab, MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule , } from '@angular/material/button';
import { MatTableDataSource, MatTableModule } from '@angular/material/table' 
import { MatIconModule } from '@angular/material/icon'; 

import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-iznajmljivanje',
  standalone: true,
   imports: [ 
        MatTabsModule, 
        MatButtonModule, 
        MatTableModule, 
        MatIconModule, 
        MatFormFieldModule, 
        MatInputModule, 
        FormsModule,
        CommonModule,
        ],
  templateUrl: './iznajmljivanje.component.html',
  styleUrl: './iznajmljivanje.component.css'
})
export class IznajmljivanjeComponent implements OnInit {

  /*id: number,
    identifikacioniDokument:string ,
    datum:string,
    trenutnaLokacija:string,
    konacnaLokacija:string,*/

  displayedColumns: string[] = ['id', 'identifikacioniDokument', 'datum' , 'trenutnaLokacija' , 'konacnaLokacija' ];

  iznajmljivanja : Iznajmljivanje[]  = [];

  constructor(private httpService : HttpService) {
    
  }

   async ngOnInit(): Promise<void> {
       let promiseFirst = new Promise((resolve) => {
            this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getIznajmljivanja").pipe(
              map((result : Iznajmljivanje[]) => {
                this.iznajmljivanja = result;
                console.log("What is inside res  " + result);
                console.log("What is inside iznajmljivanja  " + this.iznajmljivanja[0].konacnaLokacija);
                console.log("What is inside res  " + result);
                return result;
              })
            ).subscribe(() => {
              resolve("OK");
            });
          });
          //this.dataSourceAuto.data = this.dataAuto;
          // this part problematic
          let dataFirst = await promiseFirst.then(
            function(value) {
              console.log('inside promise function');
              const dataInside = value; 
              
              return dataInside;
            },
            function(error) {
              console.log("Inside promis error " + error);
            }
          );
          console.log("Data is " + dataFirst);
    }

}
