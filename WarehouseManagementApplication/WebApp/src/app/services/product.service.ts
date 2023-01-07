import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SecurityService } from './security.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient,private security:SecurityService) { }

  public getProducts(){
    const headers = this.security.getHeaders();
    return this.http.get("http://localhost:8080/api/product",{headers})
  }
}
