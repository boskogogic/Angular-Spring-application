import { Component, Inject, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogClose, MatDialogContent, MatDialogRef, MatDialogTitle } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HttpService } from '../../service/http.service';
import { environment } from '../../../../environments/environment.development';
import { Proizvodjac } from '../../prevoznasredstva/model/proizvodjac';

@Component({
  selector: 'app-create',
  standalone: true,
  imports:[ MatFormFieldModule,
      MatInputModule,
      FormsModule,
      MatButtonModule,
      MatDialogTitle,
      MatDialogContent,
      MatDialogActions,
      MatDialogClose,],
  
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent {
  readonly dialogRef = inject(MatDialogRef<CreateComponent>);
  //readonly data = inject<DialogTrotinet>(MAT_DIALOG_DATA);
  //readonly name = model(this.data.name);
  //readonly address = model(this.data.address);
  //readonly email = model(this.data.email);

  constructor(@Inject(MAT_DIALOG_DATA) public data: Proizvodjac, private httpService : HttpService) {

  }

  createTrotinet() {
    console.log("Name is " + this.data.id);
    console.log("Type is " + this.data.drzava);
    console.log("Color is " + this.data.adresa);
    console.log("Name is " + this.data.email);
    console.log("Type is " + this.data.fax);
    console.log("Color is " + this.data.telefon);
    console.log("CREATE PROIZVODJAC");
    
  }

  onCancelClick() {
    this.dialogRef.close(); 
  }
}