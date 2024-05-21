import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {ProductService} from "../services/product.service";
import {Products} from "../models/product";
import {ProductRequest} from "../models/product-request";

@Component({
  selector: 'app-product-add-form',
  templateUrl: './product-add-form.component.html',
  styleUrls: ['./product-add-form.component.css']
})
export class ProductAddFormComponent implements OnInit {
  categories?:Category[];
  product?:ProductRequest;
  constructor(private service:ProductService) { }

  ngOnInit(): void {
    this.getCategoriesForProduct();

  }
  addProduct(name:string,id:string,number:string){
    this.product={
      name:name,
      categoryId: +id,
      number:+number
    }

    this.service.addProduct(this.product);

  }
  public getCategoriesForProduct():void{
    this.service.getCategoyForProduct().subscribe(response =>{
      this.categories = <[Category]>response;
      console.log(this.categories);

    })}

}
