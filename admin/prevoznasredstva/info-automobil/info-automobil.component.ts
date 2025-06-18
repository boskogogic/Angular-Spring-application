import { Component, inject, Inject } from '@angular/core';
import { Automobil } from '../model/automobil';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-info-automobil',
  standalone: true,
  imports:[ 
    MatDialogContent,
    MatDialogActions,
    MatButtonModule,
    CommonModule 
  ],
  templateUrl: './info-automobil.component.html',
  styleUrl: './info-automobil.component.css'
})
export class InfoAutomobilComponent {
   readonly dialogRef = inject(MatDialogRef<InfoAutomobilComponent>);

  constructor(@Inject(MAT_DIALOG_DATA) public data: Automobil) {}

  onCancelClick() {
    this.dialogRef.close(); 
  }

}
