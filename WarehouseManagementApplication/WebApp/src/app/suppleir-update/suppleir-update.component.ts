import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {ActivatedRoute} from "@angular/router";
import {CategoryService} from "../services/category.service";
import {Supplier} from "../models/supplier";
import {SupplierService} from "../services/supplier.service";

@Component({
  selector: 'app-suppleir-update',
  templateUrl: './suppleir-update.component.html',
  styleUrls: ['./suppleir-update.component.css']
})
export class SuppleirUpdateComponent implements OnInit {

  id?:number;
  supplier!:Supplier;
  constructor(private route: ActivatedRoute,private service:SupplierService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {

      this.id = +(<string>params.get('id'));
    });
    this.getSupplierById()
  }

  public getSupplierById():void{
    this.service.getSupplierById(<number>this.id).subscribe(response =>{
      this.supplier = <Supplier>response;
      console.log(this.supplier)
    })


  }

  public updateCategory(name:string,address:string):void{
    this.service.updateSupplier(name,address,<number>this.id);

  }

}
