import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SecurityService } from './security.service';
import {ProductRequest} from "../models/product-request";
import {Category} from "../models/category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient,private security:SecurityService) { }

  public getCategories(){
    const headers = this.security.getHeaders();
    console.log(headers);

    return this.http.get("http://localhost:8080/api/category",{headers})
  }
  public getCategoryById(id:number){
    const headers = this.security.getHeaders();
    console.log(headers);

    return this.http.get("http://localhost:8080/api/category/"+id,{headers})
  }

  public addCategory(name:string){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/category/create", {name:name},{headers}).subscribe(respose=>{
    })
  }

  public updateCategory(name:string,id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/category/update?"+"name="+name+"&id="+id, {name:name},{headers}).subscribe(respose=>{
    })
  }

  public delete(id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.delete("http://localhost:8080/api/category/delete/"+id,{headers}).subscribe(respose=>{
    })
  }
}
