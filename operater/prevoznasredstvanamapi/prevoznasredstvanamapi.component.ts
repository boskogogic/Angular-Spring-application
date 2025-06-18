import { CommonModule } from '@angular/common';
import { Component, effect, OnInit, signal, ViewChild } from '@angular/core';
import { RouterModule } from '@angular/router';
import { GoogleMapsModule, MapInfoWindow, MapMarker } from '@angular/google-maps';
import { environment } from '../../../environments/environment.development';
import { HttpService } from '../iznajmljivanje/service/http.service';
import { Iznajmljivanje } from '../iznajmljivanje/model/iznajmljivanje';
import { Lokacija } from './model/lokacija';
import { map } from 'rxjs';

@Component({
  selector: 'app-prevoznasredstvanamapi',
  standalone: true,
  imports: [
    CommonModule,
    GoogleMapsModule,
    RouterModule,
  ],
  templateUrl: './prevoznasredstvanamapi.component.html',
  styleUrl: './prevoznasredstvanamapi.component.css'
})
export class PrevoznasredstvanamapiComponent implements OnInit {

  // api key is AIzaSyAl8ai8XOrBYAWSddfQYZ9gqMJ1wG8SHVc
  API_KEY = "AIzaSyAl8ai8XOrBYAWSddfQYZ9gqMJ1wG8SHVc";
  mapOptions!: {
    animation: google.maps.Animation;
  };
  center: google.maps.LatLngLiteral = { lat: 44.769772, lng: 17.189458 };
  zoom = 12;

  markers : google.maps.LatLngLiteral[] = [];

  dataIznajmljivanje : Iznajmljivanje[] = [];

  dataLokacije : Lokacija[] = []; 

  singleLocation :  google.maps.LatLngLiteral = {
   lat:0,
   lng: 0
  }
  brojac : number = 0;

  constructor(private httpService : HttpService) {
    
  }

  async ngOnInit(): Promise<void> {
         let promiseFirst = new Promise((resolve) => {
              this.httpService.get(environment.applicationConfig.server_url + "prevoznasredstva/getIznajmljivanja").pipe(
                map((result : Iznajmljivanje[]) => {
                  this.dataIznajmljivanje = result;
                  console.log("What is inside res  " + result);
                  console.log("What is inside iznajmljivanja  " + this.dataIznajmljivanje[0].konacnaLokacija);
                  console.log("What is inside res  " + result);
                  /*this.dataIznajmljivanje.forEach( (value) => {
                    const lokacija = value.konacnaLokacija.split(";");
                    console.log("lokacija lat " + lokacija[0]);
                    console.log("lokacija lng " + lokacija[1]);
                    console.log("brojac " + this.brojac);
                    this.singleLocation.lat = Number(lokacija[0].split(":")[1]);
                    this.singleLocation.lng = Number(lokacija[1].split(":")[1]);
                    //this.dataLokacije[this.brojac] = this.singleLocation;
                    this.markers[this.brojac] = this.singleLocation;
                    console.log(this.markers[this.brojac].lat);
                    console.log(this.markers[this.brojac].lng);
                    this.brojac++
                    
                  });*/
      
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

           
            /*this.dataIznajmljivanje.forEach( (value) => {
              const lokacija = value.konacnaLokacija.split(";");
              console.log("lokacija lat " + lokacija[0]);
              console.log("lokacija lng " + lokacija[1]);
              console.log("brojac " + this.brojac);
              this.singleLocation.lat = Number(lokacija[0].split(":")[1]);
              this.singleLocation.lng = Number(lokacija[1].split(":")[1]);
              //this.dataLokacije[this.brojac] = this.singleLocation;
              this.markers[this.brojac] = this.singleLocation;
              console.log(this.markers[this.brojac].lat);
              console.log(this.markers[this.brojac].lng);
              this.brojac++
              
            });*/

            for (var locations of this.dataIznajmljivanje) {
              const lokacija = locations.konacnaLokacija.split(";");
              console.log("lokacija lat " + lokacija[0]);
              console.log("lokacija lng " + lokacija[1]);
              console.log("brojac " + this.brojac);
              this.singleLocation.lat = Number(lokacija[0].split(":")[1]);
              this.singleLocation.lng = Number(lokacija[1].split(":")[1]);
              //this.dataLokacije[this.brojac] = this.singleLocation;
              this.markers[this.brojac] = { 
                lat: 0,
                lng: 0
              }
              this.markers[this.brojac].lat = Number(lokacija[0].split(":")[1]);
              this.markers[this.brojac].lng = Number(lokacija[1].split(":")[1]);
              console.log(this.markers[this.brojac].lat);
              console.log(this.markers[this.brojac].lng);
              this.brojac++;
            }

            for (var location of this.markers) {
              console.log("Locations: " + location.lat + " " + location.lng);
            }
    }
  
}
