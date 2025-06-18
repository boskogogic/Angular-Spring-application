
import { Component, inject, Inject } from '@angular/core';
import { Automobil } from '../model/automobil';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { Bicikl } from '../model/bicikl';

@Component({
  selector: 'app-info-bicikl',
  standalone: true,
  imports:[ 
    MatDialogContent,
    MatDialogActions,
    MatButtonModule
  ],
  
  templateUrl: './info-bicikl.component.html',
  styleUrl: './info-bicikl.component.css'
})
export class InfoBiciklComponent {

  readonly dialogRef = inject(MatDialogRef<InfoBiciklComponent>);
  
    constructor(@Inject(MAT_DIALOG_DATA) public data: Bicikl) {}
  
    onCancelClick() {
      this.dialogRef.close(); 
    }

}
