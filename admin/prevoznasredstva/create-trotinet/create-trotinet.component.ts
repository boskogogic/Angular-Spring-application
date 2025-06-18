import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HttpService } from '../../service/http.service';
import { environment } from '../../../../environments/environment.development';


export interface DialogTrotinet {
  objectId: string;
  nazivP: string;
  emailP: string;
  model: string;
  cijenaNabavke: string;
  datumNabavke: string;
}

@Component({
  selector: 'app-create-trotinet',
  standalone: true,
  imports:[ MatFormFieldModule,
      MatInputModule,
      FormsModule,
      MatButtonModule,
      MatDialogTitle,
      MatDialogContent,
      MatDialogActions,
      MatDialogClose,],
  templateUrl: './create-trotinet.component.html',
  styleUrl: './create-trotinet.component.css'
})
export class CreateTrotinetComponent {
  readonly dialogRef = inject(MatDialogRef<CreateTrotinetComponent>);
  readonly data = inject<DialogTrotinet>(MAT_DIALOG_DATA);
  //readonly name = model(this.data.name);
  //readonly address = model(this.data.address);
  //readonly email = model(this.data.email);

  constructor(private httpService : HttpService) {

  }

  createTrotinet() {
    console.log("Name is " + this.data.objectId);
    console.log("Type is " + this.data.nazivP);
    console.log("Color is " + this.data.emailP);
    console.log("Name is " + this.data.model);
    console.log("Type is " + this.data.cijenaNabavke);
    console.log("Color is " + this.data.datumNabavke);
    console.log("CREATE TROTINET");
    
  }

  onCancelClick() {
    this.dialogRef.close(); 
  }
}
