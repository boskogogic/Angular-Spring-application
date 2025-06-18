import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Proizvodjac } from '../prevoznasredstva/model/proizvodjac';
import { Automobil } from '../prevoznasredstva/model/automobil';
import { Bicikl } from '../prevoznasredstva/model/bicikl';
import { Trotinet } from '../prevoznasredstva/model/trotinet';
import { DialogAutomobil } from '../prevoznasredstva/create-automobil/create-automobil.component';
import { DialogBicikl } from '../prevoznasredstva/create-bicikl/create-bicikl.component';
import { DialogTrotinet } from '../prevoznasredstva/create-trotinet/create-trotinet.component';
import { Kvar } from '../prevoznasredstva/model/kvar';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpService : HttpClient) { }

  public get(url:string) {
    const body = {};
    return this.httpService.get<any>(url,body);
  }

  public getPaging(url:string) {
    const body = {};
    return this.httpService.get<any>(url,body);
  }

  public delete(url:string) {
    const body = {};
    return this.httpService.delete<any>(url);
  }

  public createAutomobil(url:string, automobil: DialogAutomobil) {
    const body = automobil;
    return this.httpService.post<any>(url, body);
  }

  public createBicikl(url:string, bicikl: DialogBicikl) {
    const body = { bicikl };
    return this.httpService.post<any>(url, body);
  }

  public createTrotinet(url:string, trotinet: DialogTrotinet) {
    const body = { trotinet };
    return this.httpService.post<any>(url, body);
  }

  public createProizvodjac(url:string, proizvodjac: Proizvodjac) {
    const body = { proizvodjac };
    return this.httpService.post<any>(url, body);
  }

  public createKvar(url:string, kvar: Kvar) {
    console.log("What is inside kvar " + kvar.opis); // testirano okej ispis kako treba
    // pripaziti -> izbacivalo gresku na backendu u slucaju kada je const body = { kvar } jer se onda dobija kvar: {opis:"pokvaren motor"} objekat
    // a ovako samo {opis:"Pokvaren motor"} itd
    const body = kvar;
    return this.httpService.post<any>(url, body);
  }

  public update(url:string, proizvodjac: Proizvodjac) {
    return this.httpService.put<any>(url,proizvodjac);
  }

  public updateCijenu(url:string, cijena: string) {
    return this.httpService.put<any>(url,cijena);
  }
}
