import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, NgForm } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { Automobil } from '../../admin/prevoznasredstva/model/automobil';
import { Bicikl } from '../../admin/prevoznasredstva/model/bicikl';
import { Trotinet } from '../../admin/prevoznasredstva/model/trotinet';
import { HttpService } from '../../admin/service/http.service';
import { environment } from '../../../environments/environment.development';
import { map } from 'rxjs';
import { MatButtonModule } from '@angular/material/button';
import { Kvar } from '../../admin/prevoznasredstva/model/kvar';
import { MatTabsModule } from '@angular/material/tabs';

@Component({
  selector: 'app-create-kvar',
  standalone: true,
   imports: [FormsModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule,  MatTabsModule, ],
  templateUrl: './create-kvar.component.html',
  styleUrl: './create-kvar.component.css'
})
export class CreateKvarComponent implements OnInit {

  objectId : string ='';
  opis: string = '';
  datum: string = '';
  vrijeme: string = '';
  selected = '1';

  automobili : Automobil[] = [];

  bicikli : Bicikl[] = [];

  trotineti : Trotinet[] = [];

  kvarAutomobil : Kvar = {
    objectId : '',
    opis: '',
    datum: '',
    vrijeme: ''
  }

  constructor(private httpService : HttpService) {

  }

  async ngOnInit(): Promise<void> {
    let promiseFirst = new Promise((resolve) => {
          this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getAutomobili").pipe(
            map((result : Automobil[]) => {
              this.automobili = result;
              console.log("What is inside res  " + result);
              console.log("What is inside res 0 model " + result[0].model);
              console.log("What is inside res 0 iznajmljeno " + result[0].iznajmljeno);
              console.log("What is inside res 0 iznajmljeno " + result[0].id);
              console.log("What is inside res 0 cijenaNabavke " + result[0].cijenaNabavke);
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

        let promiseSecond = new Promise((resolve) => {
          this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getBicikli").pipe(
            map((result : Bicikl[]) => {
              this.bicikli = result;
              console.log("What is inside res  " + result);
              return result;
            })
          ).subscribe(() => {
            resolve("OK");
          });
        });
    
        // this part problematic
        let dataSecond = await promiseSecond.then(
          function(value) {
            console.log('inside promise function');
            const dataInside = value; 
            return dataInside;
          },
          function(error) {
            console.log("Inside promis error " + error);
          }
        );
        console.log("Data is " + dataSecond);
    
        let promiseThird = new Promise((resolve) => {
          this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getTrotineti").pipe(
            map((result : Trotinet[]) => {
              this.trotineti = result;
              console.log("What is inside res  " + result);
              return result;
            })
          ).subscribe(() => {
            resolve("OK");
          });
        });
    
        // this part problematic
        let dataThird = await promiseThird.then(
          function(value) {
            console.log('inside promise function');
            const dataInside = value; 
            return dataInside;
          },
          function(error) {
            console.log("Inside promis error " + error);
          }
        );
        console.log("Data is " + dataThird);
  }

  

  async onSubmitAutomobilKvar() {
    this.kvarAutomobil.objectId = this.selected;
    this.kvarAutomobil.opis = this.opis;
    this.kvarAutomobil.vrijeme = this.vrijeme;
    this.kvarAutomobil.datum = this.datum;

    console.log("this.kvarAutomobil.objectId  " +this.kvarAutomobil.objectId );
    console.log("this.kvarAutomobil.opis   " +this.kvarAutomobil.opis);
    console.log("this.kvarAutomobil.vrijeme " +this.kvarAutomobil.vrijeme);
    console.log("this.kvarAutomobil.datum  " +this.kvarAutomobil.datum);
    console.log("on submit create")
    this.httpService.createKvar(environment.applicationConfig.server_url + "prevoznasredstva/createKvarAutomobila", this.kvarAutomobil).subscribe(data =>{
      console.log("Data is " + data);
      //alert("Kvar " + this.kvarAutomobil.opis + " successfully created!");
    })
    alert("Kvar " + this.kvarAutomobil.opis  + " successfully created!");
  }

  async onSubmitBiciklKvar() {
    this.kvarAutomobil.objectId = this.selected;
    this.kvarAutomobil.opis = this.opis;
    this.kvarAutomobil.vrijeme = this.vrijeme;
    this.kvarAutomobil.datum = this.datum;

    console.log("this.kvarAutomobil.objectId  " +this.kvarAutomobil.objectId );
    console.log("this.kvarAutomobil.opis   " +this.kvarAutomobil.opis);
    console.log("this.kvarAutomobil.vrijeme " +this.kvarAutomobil.vrijeme);
    console.log("this.kvarAutomobil.datum  " +this.kvarAutomobil.datum);
    console.log("on submit create")
    this.httpService.createKvar(environment.applicationConfig.server_url + "prevoznasredstva/createKvarBicikl", this.kvarAutomobil).subscribe(data =>{
      console.log("Data is " + data);
      alert("User " + this.kvarAutomobil + " successfully created!");
    })
  }

  async onSubmitTrotinetKvar() {
    this.kvarAutomobil.objectId = this.selected;
    this.kvarAutomobil.opis = this.opis;
    this.kvarAutomobil.vrijeme = this.vrijeme;
    this.kvarAutomobil.datum = this.datum;

    console.log("this.kvarAutomobil.objectId  " +this.kvarAutomobil.objectId );
    console.log("this.kvarAutomobil.opis   " +this.kvarAutomobil.opis);
    console.log("this.kvarAutomobil.vrijeme " +this.kvarAutomobil.vrijeme);
    console.log("this.kvarAutomobil.datum  " +this.kvarAutomobil.datum);
    console.log("on submit create")
    this.httpService.createKvar(environment.applicationConfig.server_url + "prevoznasredstva/createKvarTrotinet", this.kvarAutomobil).subscribe(data =>{
      console.log("Data is " + data);
      alert("User " + this.kvarAutomobil + " successfully created!");
    })
  }
    
}
