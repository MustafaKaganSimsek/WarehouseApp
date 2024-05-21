import { Component, OnInit } from '@angular/core';
import { Products } from '../models/product';
import { ProductService } from '../services/product.service';
import {Category} from "../models/category";

@Component({
  selector: 'product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products?:Products[];

  constructor(private service:ProductService) { }

  ngOnInit(): void {
    this.getProducts();
  }


  public getProducts():void{
    this.service.getProducts().subscribe(response =>{
      this.products = <[Products]>response;
      console.log(this.products);

    })

  }

  public delete(id:number):void{
    this.service.delete(id);

  }
}
