import { Component, inject, OnInit } from '@angular/core';
import { MatTab, MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule , } from '@angular/material/button';
import { MatTableDataSource, MatTableModule } from '@angular/material/table' 
import { MatIconModule } from '@angular/material/icon'; 
import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FileuploadComponent } from './fileupload/fileupload.component';
import { Automobil } from './model/automobil';
import { Trotinet } from './model/trotinet';
import { Bicikl } from './model/bicikl';
import { environment } from '../../../environments/environment.development';
import { map } from 'rxjs';
import { HttpService } from '../service/http.service';
import { InfoAutomobilComponent } from './info-automobil/info-automobil.component';
import { CreateAutomobilComponent, DialogAutomobil } from './create-automobil/create-automobil.component';
import { CreateBiciklComponent, DialogBicikl } from './create-bicikl/create-bicikl.component';
import { DialogTrotinet } from './create-trotinet/create-trotinet.component';
import { InfoBiciklComponent } from './info-bicikl/info-bicikl.component';
import { InfoTrotinetComponent } from './info-trotinet/info-trotinet.component';
import { MatPaginatorModule, PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-prevoznasredstva',
  standalone: true,
  imports: [ 
    MatTabsModule, 
    MatButtonModule, 
    MatTableModule, 
    MatIconModule, 
    MatFormFieldModule, 
    MatInputModule, 
    FormsModule,
    CommonModule,
    //MatTableDataSource,
    FileuploadComponent,
    MatPaginatorModule
    ],
  templateUrl: './prevoznasredstva.component.html',
  styleUrl: './prevoznasredstva.component.css'
})


export class PrevoznasredstvaComponent implements OnInit {

  readonly dialog = inject(MatDialog);

  searchText: string = '';  // Text entered for searching by Name

  displayedColumns: string[] = ['position', 'proizvodjac', 'model',  'delete', 'detalji'];

  dataAuto : Automobil[] = [] ;

  dataTrotinet : Trotinet[] = [] ;

  dataBicikl : Bicikl[] = [] ;   
    
    //dataSourceAuto = new MatTableDataSource(this.dataAuto);
  dataSourceAuto = new MatTableDataSource<Automobil>([]);
  //dataSourceAuto : MatTableDataSource<any> = new MatTableDataSource();
  objectID: string = '';
  nazivP: string = '';
  emailP: string = '';
  model: string = '';
  cijenaNabavke: string = '';
  datumNabavke: string = '';

  passedValues: object | undefined ;
  automobil : DialogAutomobil | undefined;
  bicikl : DialogBicikl | undefined;
  trotinet : DialogTrotinet | undefined;

  lengthVar = 12;
  pageSizeVar = 3;
  pageIndexVar = 0;
  pageEvent: PageEvent = {
    pageIndex: this.pageIndexVar,
    pageSize: this.pageSizeVar,
    length: this.lengthVar
  };


  constructor(private httpService : HttpService) {}


  async ngOnInit(): Promise<void> {
    let promiseFirst = new Promise((resolve) => {
      /*this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getAutomobili").pipe(
        map((result : Automobil[]) => {
          this.dataAuto = result;
          console.log("What is inside res  " + result);
          console.log("What is inside res 0 model " + result[0].model);
          console.log("What is inside res 0 iznajmljeno " + result[0].iznajmljeno);
          console.log("What is inside res 0 iznajmljeno " + result[0].id);
          console.log("What is inside res 0 cijenaNabavke " + result[0].cijenaNabavke);
          this.dataSourceAuto = new MatTableDataSource(this.dataAuto);
          return result;
        })
      ).subscribe(() => {
        resolve("OK");
      });*/
      this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getAutomobiliPaging?stranica="+this.pageIndexVar+"&brojObjekata="+this.pageSizeVar).pipe(
        map((result : Automobil[]) => {
          this.dataAuto = result;
          console.log("What is inside res  " + result);
          console.log("What is inside res 0 model " + result[0].model);
          console.log("What is inside res 0 iznajmljeno " + result[0].iznajmljeno);
          console.log("What is inside res 0 iznajmljeno " + result[0].id);
          console.log("What is inside res 0 cijenaNabavke " + result[0].cijenaNabavke);
          this.dataSourceAuto = new MatTableDataSource(this.dataAuto);
          return result;
        })
      ).subscribe(() => {
        resolve("OK");
      });
    });
    //this.dataSourceAuto.data = this.dataAuto;
    // this part problematic
    let dataFirst = await promiseFirst.then(
      function(value) {
        console.log('inside promise function');
        const dataInside = value; 
        
        return dataInside;
      },
      function(error) {
        console.log("Inside promis error " + error);
      }
    );
    console.log("Data is " + dataFirst);
    //this.dataSourceAuto.data = this.dataAuto;
    
    let promiseSecond = new Promise((resolve) => {
      this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getBicikli").pipe(
        map((result : Bicikl[]) => {
          this.dataBicikl = result;
          console.log("What is inside res  " + result);
          return result;
        })
      ).subscribe(() => {
        resolve("OK");
      });
    });

    // this part problematic
    let dataSecond = await promiseSecond.then(
      function(value) {
        console.log('inside promise function');
        const dataInside = value; 
        return dataInside;
      },
      function(error) {
        console.log("Inside promis error " + error);
      }
    );
    console.log("Data is " + dataSecond);

    let promiseThird = new Promise((resolve) => {
      this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getTrotineti").pipe(
        map((result : Trotinet[]) => {
          this.dataTrotinet = result;
          console.log("What is inside res  " + result);
          return result;
        })
      ).subscribe(() => {
        resolve("OK");
      });
    });

    // this part problematic
    let dataThird = await promiseThird.then(
      function(value) {
        console.log('inside promise function');
        const dataInside = value; 
        return dataInside;
      },
      function(error) {
        console.log("Inside promis error " + error);
      }
    );
    console.log("Data is " + dataThird);
  }


  deleteAutomobil(id : string) {
    console.log("Delete automobil starts....");
      //need to add BL of deleting signle automobil
    console.log("Url is " + environment.applicationConfig.server_url + "prevoznasredstva/deleteAutomobil?id="+id);
    // don't forget -> You always need to subscribe on request
    this.httpService.delete(environment.applicationConfig.server_url + "prevoznasredstva/deleteAutomobil?id="+id).subscribe();
  }

  deleteBicikl(id : string) {
    //need to add BL of deleting signle automobil
    console.log("Delete Bicikl starts....");
      //need to add BL of deleting signle automobil
    console.log("Url is " + environment.applicationConfig.server_url + "prevoznasredstva/deleteBicikl?id="+id);
    // don't forget -> You always need to subscribe on request
    this.httpService.delete(environment.applicationConfig.server_url + "prevoznasredstva/deleteBicikl?id="+id).subscribe();
  }

  deleteTrotinet(id : string) {
    //need to add BL of deleting signle automobil
    console.log("Delete automobil starts....");
      //need to add BL of deleting signle automobil
    console.log("Url is " + environment.applicationConfig.server_url + "prevoznasredstva/deleteTrotinet?id="+id);
    // don't forget -> You always need to subscribe on request
    this.httpService.delete(environment.applicationConfig.server_url + "prevoznasredstva/deleteTrotinet?id="+id).subscribe();
  }

  detaljiAuto(automobil : Automobil) {
    console.log("detaljiAuto start.....");
    const dialogRef = this.dialog.open(InfoAutomobilComponent, {
      width: '500px',  // Optional: set dialog width
      data: automobil       // Passing the clicked user object to the dialog
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  detaljiBicikl(bicikl : Bicikl) {
    console.log("detaljiBicikl start.....");
    const dialogRef = this.dialog.open(InfoBiciklComponent, {
      width: '500px',  // Optional: set dialog width
      data: bicikl       // Passing the clicked user object to the dialog
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  detaljiTrotinet(trotinet : Trotinet) {
    console.log("detaljiTrotinet start.....");
    const dialogRef = this.dialog.open(InfoTrotinetComponent, {
      width: '500px',  // Optional: set dialog width
      data: trotinet       // Passing the clicked user object to the dialog
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  showModal() {
    console.log("showModal start.....");
   
  }

  uploadAutomobilCSVFile() {
    // implement uploading and parsing CSV fajl
  }

    // Apply the filter to the data
  applyFilterAutomobil() {
    // If the search text is empty, we return all data
    if (!this.searchText) {
      this.dataSourceAuto.filter = '';
    } else {
      // Otherwise, filter based on the name column
      this.dataSourceAuto.filter = this.searchText.trim().toLowerCase();
    }
  }

  createAutomobil() {
    console.log("createAutomobil start.....");
    let dialogRef = this.dialog.open(CreateAutomobilComponent, {
      height: '600px',
      width: '400px',
      data: { objectID: this.objectID, nazivP: this.nazivP, emailP: this.emailP, 
        model: this.model, cijenaNabavke : this.cijenaNabavke, datumNabavke: this.datumNabavke }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log("This dialog is closed");
      console.log("What is inside result name " + result.name);
      console.log("What is inside result type " + result.type);
      console.log("What is inside result color " + result.color);
      this.automobil = result;
      //console.log("USER NAME FROM DIALOG " + this.automobil?.name);
      if (this.automobil != null) {
        console.log("user != null")
        //beware -> You need to ! subscribe or pipe request !!
        this.httpService.createAutomobil(environment.applicationConfig.server_url + 'prevoznasredstva/createAutomobil',  this.automobil)
          .subscribe(data =>{
            console.log("Data is " + data);
            alert("Automobil " + this.automobil?.model + " successfully created!");
        })
      }
    })
  }

  createBicikl() {
      console.log("createBicikl start.....");
      let dialogRef = this.dialog.open(CreateBiciklComponent, {
        height: '600px',
        width: '400px',
        data: { objectID: this.objectID, nazivP: this.nazivP, emailP: this.emailP, 
          model: this.model, cijenaNabavke : this.cijenaNabavke, datumNabavke: this.datumNabavke }
      });
  
      dialogRef.afterClosed().subscribe(result => {
        console.log("This dialog is closed");
        this.bicikl = result;
        //console.log("USER NAME FROM DIALOG " + this.automobil?.name);
        if (this.bicikl != null) {
          console.log("bicikl != null")
          console.log("this.bicikl.nazivP " + this.bicikl.nazivP);
          //beware -> You need to ! subscribe or pipe request !!
          this.httpService.createBicikl(environment.applicationConfig.server_url + 'prevoznasredstva/createBicikl',  this.bicikl)
            .subscribe(data =>{
              console.log("Data is " + data);
              alert("User " + this.bicikl?.model + " successfully created!");
          })
        }
      })
    }

      createTrotinet() {
        console.log("createTrotinet start.....");
        let dialogRef = this.dialog.open(CreateAutomobilComponent, {
          height: '600px',
          width: '400px',
          data: { objectID: this.objectID, nazivP: this.nazivP, emailP: this.emailP, 
            model: this.model, cijenaNabavke : this.cijenaNabavke, datumNabavke: this.datumNabavke }
        });
    
        dialogRef.afterClosed().subscribe(result => {
          console.log("This dialog is closed");
          this.trotinet = result;
          //console.log("USER NAME FROM DIALOG " + this.automobil?.name);
          if (this.trotinet != null) {
            console.log("user != null")
            //beware -> You need to ! subscribe or pipe request !!
            this.httpService.createTrotinet(environment.applicationConfig.server_url + 'prevoznasredstva/createTrotinet',  this.trotinet)
              .subscribe(data =>{
                console.log("Data is " + data);
                alert("User " + this.automobil?.model + " successfully created!");
            })
          }
        })
      }

    handlePageEvent(e: PageEvent) {
        this.pageEvent = e;
        this.lengthVar = e.length;
        this.pageSizeVar = e.pageSize;
        this.pageIndexVar = e.pageIndex;
        console.log("Page " + this.pageEvent);
        console.log("Page lengthVar " + this.lengthVar);
        console.log("Page pageSizeVar " + this.pageSizeVar);
        console.log("Page pageIndexVar " + this.pageIndexVar);
   
          this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getAutomobiliPaging?stranica="+this.pageIndexVar+"&brojObjekata="+this.pageSizeVar)
          .subscribe(result => {
            this.dataAuto = result;
            console.log("What is inside res  " + result);
            console.log("What is inside res 0 model " + result[0].model);
            console.log("What is inside res 0 iznajmljeno " + result[0].iznajmljeno);
            console.log("What is inside res 0 iznajmljeno " + result[0].id);
            console.log("What is inside res 0 cijenaNabavke " + result[0].cijenaNabavke);
            this.dataSourceAuto = new MatTableDataSource(this.dataAuto);
            return result;
          })
    
      }
    
}

