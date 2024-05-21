import { Component, OnInit } from '@angular/core';
import {Order} from "../models/order";
import {OrderService} from "../services/order.service";
import {Supplier} from "../models/supplier";
import {SupplierService} from "../services/supplier.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-supplier-list',
  templateUrl: './supplier-list.component.html',
  styleUrls: ['./supplier-list.component.css']
})
export class SupplierListComponent implements OnInit {

  suppliers?:Supplier[];

  constructor(private service:SupplierService,private router:Router) { }

  ngOnInit(): void {
    this.getSuppliers()
  }

  addSupplier(name:string,address:string){

    this.service.addSupplier(name, address);

  }
  public getSuppliers():void{
    this.service.getSupplier().subscribe(response =>{
      this.suppliers = <[Supplier]>response;
      console.log(this.suppliers);

    })

  }
  public delete(id:number):void{
    this.service.delete(id);

  }
}
