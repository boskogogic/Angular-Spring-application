
import { Component, inject, OnInit } from '@angular/core';
import { MatTab, MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule , } from '@angular/material/button';
import { MatTableDataSource, MatTableModule } from '@angular/material/table' 
import { MatIconModule } from '@angular/material/icon'; 

import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { environment } from '../../../environments/environment.development';
import { map } from 'rxjs';
import { HttpService } from '../service/http.service';
import { Proizvodjac } from '../prevoznasredstva/model/proizvodjac';
import { UpdateProizvodjacComponent } from './update-proizvodjac/update-proizvodjac.component';
import { CreateComponent } from './create/create.component';


@Component({
  selector: 'app-proizvodjaci',
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
  
  templateUrl: './proizvodjaci.component.html',
  styleUrl: './proizvodjaci.component.css'
})
export class ProizvodjaciComponent implements OnInit {

  readonly dialog = inject(MatDialog);

  id: number = 0;
  adresa: string = '';
  drzava: string = '';
  email: string = '';
  fax: string = '';
  naziv: string = '';
  telefon: string = '';


  // naziv, država, adresa i kontakt podaci (telefon, fax, email).
  displayedColumns: string[] = ['id', 'naziv', 'email' , 'delete' , 'update' ];

  proizvodjaci : Proizvodjac[] = [];

  proizvodjac : Proizvodjac | undefined;

  proizvodjacForCreate : Proizvodjac | undefined;

  constructor(private httpService : HttpService) {}


  async ngOnInit(): Promise<void> {
     let promiseFirst = new Promise((resolve) => {
          this.httpService.get(environment.applicationConfig.server_url + "proizvodjac/getProizvodjaci").pipe(
            map((result : Proizvodjac[]) => {
              this.proizvodjaci = result;
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

  deleteProizvodjac(id: number) { 
     //need to add BL of deleting signle automobil
     console.log("Delete Bicikl starts....");
     //need to add BL of deleting signle automobil
   console.log("Url is " + environment.applicationConfig.server_url + "proizvodjac/deleteProizvodjac?id="+id);
   // don't forget -> You always need to subscribe on request
   this.httpService.delete(environment.applicationConfig.server_url + "proizvodjac/deleteProizvodjac?id="+id).subscribe();
  }

  /*updateProizvodjac(proizvodjac: Proizvodjac) {

  }*/



  updateProizvodjac(proizvodjac : Proizvodjac) {
      console.log("showModal start.....");
      let dialogRef = this.dialog.open(UpdateProizvodjacComponent, {
        height: '500px',
        width: '500px',
        data: proizvodjac
      });
  
      dialogRef.afterClosed().subscribe(result => {
        console.log("This dialog is closed");
        console.log("What is inside result name " + result.name);
        console.log("What is inside result type " + result.type);
        console.log("What is inside result color " + result.color);
        this.proizvodjac = result;
        console.log("USER NAME FROM DIALOG " + this.proizvodjac?.naziv);
        if (this.proizvodjac != null) {
          console.log("proizvodjac != null")
          //beware -> You need to ! subscribe or pipe request !!
          //this.httpService.postUser(environment.applicationConfig.server_url + 'rest/user/createUser', this.user)
           // .subscribe(data =>{
           // console.log("Data is " + data);
          //  alert("User " + this.user?.name + " successfully created!");
         // })
        }
      })
    }

    create() {
      console.log("create proizvodjac start.....");
      let dialogRef = this.dialog.open(CreateComponent, {
        height: '500px',
        width: '500px',
        data: { id: this.id, adresa: this.adresa, drzava: this.drzava, email: this.email,
          fax: this.fax, naziv: this.naziv, telefon: this.telefon, }
      
      });
  
      dialogRef.afterClosed().subscribe(result => {
        console.log("create proizvodjac dialog is closed");
        this.proizvodjacForCreate = result;
        console.log("NAZIV FROM DIALOG " + this.proizvodjacForCreate?.naziv);
        if (this.proizvodjacForCreate != null) {
          console.log("proizvodjac != null")
          //beware -> You need to ! subscribe or pipe request !!
          this.httpService.createProizvodjac(environment.applicationConfig.server_url + 'proizvodjac/createProizvodjac', this.proizvodjacForCreate)
            .subscribe(data =>{
            console.log("Data is " + data);
            alert("User " + this.proizvodjacForCreate?.naziv + " successfully created!");
          })
        }
      })
    }


}
