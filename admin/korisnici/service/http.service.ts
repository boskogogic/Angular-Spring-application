import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

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
  
    public create(url:string) {
      const body = {};
      return this.httpService.post<any>(url,body);
    }

    public blokiraj(url:string, id: number) {
      const body = {};
      console.log("BLokiraj url is "  + url);
      console.log("Id from body is " + id);
      return this.httpService.put<any>(url,id);
    }

    public deblokiraj(url:string, id: number) {
      const body = {};
      return this.httpService.put<any>(url,id);
    }
  
    /*public update(url:string, proizvodjac: Proizvodjac) {
      return this.httpService.put<any>(url,proizvodjac);
    }*/
}
