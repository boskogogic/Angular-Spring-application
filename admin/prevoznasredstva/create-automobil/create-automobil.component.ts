import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HttpService } from '../../service/http.service';
import { environment } from '../../../../environments/environment.development';


export interface DialogAutomobil {
  objectId: string;
  nazivP: string;
  emailP: string;
  model: string;
  cijenaNabavke: string;
  datumNabavke: string;
}

@Component({
  selector: 'app-create-automobil',
  standalone: true,
  imports:[ MatFormFieldModule,
      MatInputModule,
      FormsModule,
      MatButtonModule,
      MatDialogTitle,
      MatDialogContent,
      MatDialogActions,
      MatDialogClose,],
  templateUrl: './create-automobil.component.html',
  styleUrl: './create-automobil.component.css'
})
export class CreateAutomobilComponent {
  readonly dialogRef = inject(MatDialogRef<CreateAutomobilComponent>);
  readonly data = inject<DialogAutomobil>(MAT_DIALOG_DATA);
  //readonly name = model(this.data.name);
  //readonly address = model(this.data.address);
  //readonly email = model(this.data.email);

  constructor(private httpService : HttpService) {

  }

  createAutomobil() {
    console.log("Name is " + this.data.objectId);
    console.log("Type is " + this.data.nazivP);
    console.log("Color is " + this.data.emailP);
    console.log("Name is " + this.data.model);
    console.log("Type is " + this.data.cijenaNabavke);
    console.log("Color is " + this.data.datumNabavke);
    console.log("CREATE AUTOMOBIL");
    
  }

  onCancelClick() {
    this.dialogRef.close(); 
  }
}
