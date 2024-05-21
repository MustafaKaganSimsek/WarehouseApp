import { SecurityService } from './security.service';
import {Injectable} from "@angular/core";
import { HttpClient } from '@angular/common/http';
import {ProductRequest} from "../models/product-request";


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient,private security:SecurityService) { }

  public addOrder(productId:number,supplierId:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/order/save", {productId:productId,suppleirId:supplierId},{headers}).subscribe(respose=>{
    })
  }
  public updateOrder(productId:number,supplierId:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.post<ProductRequest>("http://localhost:8080/api/order/update", {productId:productId,suppleirId:supplierId},{headers}).subscribe(respose=>{
    })
  }

  public getOrderById(id:string){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.get<ProductRequest>("http://localhost:8080/api/order/"+id,{headers}).subscribe(respose=>{
    })
  }
  public getOrders(){
    const headers = this.security.getHeaders();
    console.log(headers);

    return this.http.get("http://localhost:8080/api/order",{headers})
  }

  public delete(id:number){
    const headers = this.security.getHeaders();
    console.log(headers);
    return this.http.delete("http://localhost:8080/api/order/delete/"+id,{headers}).subscribe(respose=>{
    })
  }
}
