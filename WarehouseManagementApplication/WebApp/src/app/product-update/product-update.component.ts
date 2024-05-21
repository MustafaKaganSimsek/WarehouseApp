import { Component, OnInit } from '@angular/core';
import {Supplier} from "../models/supplier";
import {ActivatedRoute, Router} from "@angular/router";
import {SupplierService} from "../services/supplier.service";
import {Products} from "../models/product";
import {ProductService} from "../services/product.service";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  id?:number;
  product!:Products;
  constructor(private route: ActivatedRoute,private service:ProductService,private router:Router) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {

      this.id = +(<string>params.get('id'));
    });
    this.getProductById()
  }

  public getProductById():void{
    this.service.getProductById(<number>this.id).subscribe(response =>{
      this.product = <Products>response;
    })

  }

  public updateProduct(name:string,number:string):void{
    this.service.updateProduct(name,+number,<number>this.id);
  }

}
