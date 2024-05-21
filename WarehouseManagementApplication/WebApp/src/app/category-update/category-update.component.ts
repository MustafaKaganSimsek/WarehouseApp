import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Category} from "../models/category";
import {CategoryService} from "../services/category.service";

@Component({
  selector: 'app-category-update',
  templateUrl: './category-update.component.html',
  styleUrls: ['./category-update.component.css']
})
export class CategoryUpdateComponent implements OnInit {
  id?:number;
  category!:Category;
  constructor(private route: ActivatedRoute,private service:CategoryService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {

      this.id = +(<string>params.get('id'));
    });
    this.getCateroriyById()
  }

  public getCateroriyById():void{
    this.service.getCategoryById(<number>this.id).subscribe(response =>{
      this.category = <Category>response;
      console.log(this.category);

    })

  }

  public updateCategory(name:string):void{
    this.service.updateCategory(name,<number>this.id);
      console.log(this.category);

  }



}
