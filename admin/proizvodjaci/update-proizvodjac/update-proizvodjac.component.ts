import { Component, Inject, inject } from '@angular/core';
import { Proizvodjac } from '../../prevoznasredstva/model/proizvodjac';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { HttpService } from '../../service/http.service';
import { environment } from '../../../../environments/environment.development';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-update-proizvodjac',
  standalone: true,
  imports:[ 
    MatDialogContent,
    MatDialogActions,
    MatButtonModule, 
    FormsModule 
  ],
  
  templateUrl: './update-proizvodjac.component.html',
  styleUrl: './update-proizvodjac.component.css'
})
export class UpdateProizvodjacComponent {

  readonly dialogRef = inject(MatDialogRef<UpdateProizvodjacComponent>);
  
    constructor(@Inject(MAT_DIALOG_DATA) public data: Proizvodjac, private httpService : HttpService) {}

    id: number = 0;
    adresa: string = '';
    drzava: string = '';
    email: string = '';
    fax: string = '';
    naziv: string = '';
    telefon: string = '';
  
    // this is how to declare complicated object !!
    dataForUpdate: Proizvodjac = {
      id: 0,
      adresa:  '',
      drzava: '',
      email: '',
      fax: '',
      naziv:  '',
      telefon:  ''
    }
  
  
    onCancelClick() {
      this.dialogRef.close(); 
    }

    updateClick() {
      console.log("adresa is " + this.adresa);
      console.log("drzava is " + this.drzava);
      console.log("id is " + this.data.id);

      this.dataForUpdate.id = this.data.id;

      // nothing to update
      if (this.adresa === '' && 
         this.drzava  === '' && 
        this.email  === '' &&
        this.fax  === '' &&
        this.naziv  === '' && 
        this.telefon  === ''
      ) {
        alert('Nothing to update');
      } else {
        // same
        if (this.data.adresa === this.adresa) {
          this.dataForUpdate.adresa = this.data.adresa;
          // not same
        } else  {
          this.dataForUpdate.adresa = this.adresa;
        }
        
        if (this.data.drzava === this.drzava) {
          this.dataForUpdate.drzava = this.data.drzava;

        } else {
          this.dataForUpdate.drzava = this.drzava;
        }
        
        if (this.data.email === this.email) {
          this.dataForUpdate.email = this.data.email;
        } else {
          this.dataForUpdate.email = this.email;
        }
        
        if (this.data.fax === this.fax) {
          this.dataForUpdate.fax = this.data.fax;
        } else {
          this.dataForUpdate.fax = this.fax;
        }
        
        if (this.data.naziv === this.naziv) {
          this.dataForUpdate.naziv = this.data.naziv;
        } else {
          this.dataForUpdate.naziv = this.naziv;
        } 
        
        if (this.data.telefon === this.telefon) {
          this.dataForUpdate.telefon = this.data.telefon;
        } else {
          this.dataForUpdate.telefon = this.telefon;
        }

        console.log("Need to update proizvodjac")
        this.httpService.update(environment.applicationConfig.server_url + "proizvodjac/updateProizvodjac",this.dataForUpdate).subscribe(result => {
          console.log("Result of update is " + result);
          alert(result);
        })
        this.dialogRef.close(); 
      }



    
      //console.log("Color is " + this.dataForUpdate.emailP);
      //console.log("Name is " + this.dataForUpdate.model);
      //console.log("Type is " + this.dataForUpdate.cijenaNabavke);
      //console.log("Color is " + this.dataForUpdate.datumNabavke);
      console.log("update click");
    }

}
