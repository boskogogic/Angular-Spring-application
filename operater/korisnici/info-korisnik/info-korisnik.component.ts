import { Component, inject, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { Korisnik } from '../model/korisnik';

@Component({
  selector: 'app-info-korisnik',
  standalone: true,
  imports:[ 
    MatDialogContent,
    MatDialogActions,
    MatButtonModule
  ],
  templateUrl: './info-korisnik.component.html',
  styleUrl: './info-korisnik.component.css'
})
export class InfoKorisnikComponent {
   readonly dialogRef = inject(MatDialogRef<InfoKorisnikComponent>);

  constructor(@Inject(MAT_DIALOG_DATA) public data: Korisnik) {}

  onCancelClick() {
    this.dialogRef.close(); 
  }

}
