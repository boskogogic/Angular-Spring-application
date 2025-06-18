import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpService : HttpClient) { }

  public get(url:string) {
    const body = {};
    return this.httpService.get<any>(url,body);
  }

  public delete(url:string) {
    const body = {};
    return this.httpService.delete<any>(url);
  }

  /*public update(url:string, proizvodjac: Proizvodjac) {
    return this.httpService.put<any>(url,proizvodjac);
  }*/
}
