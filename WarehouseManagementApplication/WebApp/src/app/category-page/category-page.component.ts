import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../services/category.service";
import {Products} from "../models/product";
import {Category} from "../models/category";

@Component({
  selector: 'category-page',
  templateUrl: './category-page.component.html',
  styleUrls: ['./category-page.component.css']
})
export class CategoryPageComponent implements OnInit {
  categories?:Category[];

  constructor(private service:CategoryService) { }

  ngOnInit(): void {
    this.getCaterories()
  }

  addCategory(name:string){

    this.service.addCategory(name);

  }
  public getCaterories():void{
    this.service.getCategories().subscribe(response =>{
      this.categories = <[Category]>response;
      console.log(this.categories);

    })

  }
  public delete(id:number):void{
    this.service.delete(id);

  }
}
