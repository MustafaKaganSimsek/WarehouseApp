import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SecurityService } from './security.service';
import {ProductRequest} from "../models/product-request";
import {Products} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient,private security:SecurityService) { }

  public getProducts(){
    const headers = this.security.getHeaders();
    console.log(headers);

    return this.http.get("http://localhost:8080/api/product",{headers})
  }

  public addProduct(product:ProductRequest){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/product/creates?categoyId", product,{headers}).subscribe(respose=>{
    })
  }

  public updateProduct(name:string,number:number,id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/product/update?name="+name+"&number="+number+"&id="+id, {},{headers}).subscribe(respose=>{

    })
  }

  public getProductById(id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.get<Products>("http://localhost:8080/api/product/"+id,{headers})
  }

  public getCategoyForProduct(){
    const headers = this.security.getHeaders();
    console.log(headers);

    return this.http.get("http://localhost:8080/api/category",{headers})
  }

  public delete(id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.delete("http://localhost:8080/api/product/delete/"+id,{headers}).subscribe(respose=>{
    })
  }
}
