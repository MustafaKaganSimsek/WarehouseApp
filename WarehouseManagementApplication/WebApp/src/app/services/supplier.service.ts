import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SecurityService } from './security.service';
import {ProductRequest} from "../models/product-request";

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  constructor(private http:HttpClient,private security:SecurityService) { }

  public getSupplier(){
    const headers = this.security.getHeaders();
    console.log(headers);

    return this.http.get("http://localhost:8080/api/supplier",{headers})
  }

  public getSupplierById(id:number){
    const headers = this.security.getHeaders();
    console.log(headers);

    return this.http.get("http://localhost:8080/api/supplier/"+id,{headers})
  }

  public addSupplier(name:string,address:string){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/supplier/save", {name:name,address:address},{headers}).subscribe(respose=>{
    })
  }

  public updateSupplier(name:string,address:string,id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/supplier/update/"+id+"?name="+name+"&address="+address, {},{headers}).subscribe(respose=>{
    })
  }
  public delete(id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.delete("http://localhost:8080/api/supplier/delete/"+id,{headers}).subscribe(respose=>{
    })
  }
}
