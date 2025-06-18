import { Component, OnInit } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule , } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table' 
import { MatIconModule } from '@angular/material/icon'; 
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Zaposleni } from './model/zaposleni';
import { environment } from '../../../environments/environment.development';

import { map } from 'rxjs';
import { Korisnik } from './model/korisnik';
import { HttpService } from './service/http.service';


@Component({
  selector: 'app-korisnici',
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
  
  templateUrl: './korisnici.component.html',
  styleUrl: './korisnici.component.css'
})
export class KorisniciOperaterComponent implements OnInit {
  
  displayedColumnsKlijenti: string[] = ['position', 'email', 'korisnickoIme', 'block', 'isblock' ];

  dataKlijenti : Korisnik[] = [] ;

  isBlocked: boolean = false;  

  constructor(private httpService : HttpService) {

  }


  block(element : Korisnik) {
    //this.isBlocked = !this.isBlocked;  // Toggle the state
    if (!element.blokiran) {
      // Perform the action when button is clicked (BLOKIRAJ)
      console.log('Performing action for BLOKIRAJ');
      this.httpService.blokiraj(environment.applicationConfig.server_url + "korisnik/blokiraj", element.id).subscribe(result => {
        console.log("user is blocked");
        alert("User with ID " + element.id + " is blocked");
      })
    } else {
      this.httpService.deblokiraj(environment.applicationConfig.server_url + "korisnik/odblokiraj", element.id).subscribe(result => {
        console.log("user is blocked");
        alert("User with ID " + element.id + " is unblocked");
      })
    }
  }


  async ngOnInit(): Promise<void> {
      let promiseFirst = new Promise((resolve) => {
        this.httpService.get(environment.applicationConfig.server_url + "korisnik/getKorisnici").pipe(
          map((result : Korisnik[]) => {
            this.dataKlijenti = result;
            console.log("What is inside res  " + result);

            console.log("What is inside res 0 iznajmljeno " + result[0].id);

            //this.dataSourceAuto = new MatTableDataSource(this.dataAuto);
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
