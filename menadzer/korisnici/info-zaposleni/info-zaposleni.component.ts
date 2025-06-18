import { Component, inject, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { Korisnik } from '../model/korisnik';
import { Zaposleni } from '../model/zaposleni';

@Component({
  selector: 'app-info-zaposleni',
  standalone: true,
  imports:[ 
    MatDialogContent,
    MatDialogActions,
    MatButtonModule
  ],
  templateUrl: './info-zaposleni.component.html',
  styleUrl: './info-zaposleni.component.css'
})
export class InfoZaposleniComponent {
   readonly dialogRef = inject(MatDialogRef<InfoZaposleniComponent>);

  constructor(@Inject(MAT_DIALOG_DATA) public data: Zaposleni) {}

  onCancelClick() {
    this.dialogRef.close(); 
  }

}
