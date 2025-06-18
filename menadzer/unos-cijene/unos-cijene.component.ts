import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, NgForm } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { HttpService } from '../../admin/service/http.service';
import { environment } from '../../../environments/environment.development';


@Component({
  selector: 'app-unos-cijene',
  standalone: true,
  imports : [ FormsModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule, MatDividerModule],
  templateUrl: './unos-cijene.component.html',
  styleUrl: './unos-cijene.component.css'
})
export class UnosCijeneComponent {

  cijenaIznajmljivanjaAutomobila : string = '';
  cijenaIznajmljivanjaBicikla : string = '';
  cijenaIznajmljivanjaTrotineta : string = '';

  constructor(private httpService : HttpService) {

  }

  onSubmitAutomobilCijena() {
    console.log("cijenaIznajmljivanjaAutomobila " + this.cijenaIznajmljivanjaAutomobila);
    this.httpService.updateCijenu(environment.applicationConfig.server_url + "prevoznasredstva/updateCijenaAutomobila", this.cijenaIznajmljivanjaAutomobila).subscribe();
  }

  onSubmitBiciklCijena() {

  }

  onSubmitTrotinetCijena() {

  }
}
