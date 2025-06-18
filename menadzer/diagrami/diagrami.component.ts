import { Component } from '@angular/core';
import { BrojKvarovaPoPrevoznomsredstvuComponent } from './broj-kvarova-po-prevoznomsredstvu/broj-kvarova-po-prevoznomsredstvu.component';
import { MatTabsModule } from '@angular/material/tabs';
import { UkupniPrihodiPrevoznosredstvoComponent } from './ukupni-prihodi-prevoznosredstvo/ukupni-prihodi-prevoznosredstvo.component';

@Component({
  selector: 'app-diagrami',
  standalone: true,
  imports: [BrojKvarovaPoPrevoznomsredstvuComponent, MatTabsModule, UkupniPrihodiPrevoznosredstvoComponent],
  
  templateUrl: './diagrami.component.html',
  styleUrl: './diagrami.component.css'
})
export class DiagramiComponent {

  /* NAPOMENA -> Kada su se dijagrami pravili u konstruktorima komponenti -> Prikazivali su se tek nakon klika na Inspect 
                 Problem je bio u tom "dobavljanju"; Kada se preslo na ngOnInit -> Radi sve normalno, 
                 jer se dijagrami dobavljaju prilikom inicijalizacije 
   */
}
