import { Component, OnInit } from '@angular/core';
import {Category} from "../models/category";
import {CategoryService} from "../services/category.service";
import {Order} from "../models/order";
import {OrderService} from "../services/order.service";
import {ProductService} from "../services/product.service";
import {SupplierService} from "../services/supplier.service";
import {Products} from "../models/product";
import {Supplier} from "../models/supplier";

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders?:Order[];
  products?:Products[];
  suppliers?:Supplier[];


  constructor(private service:OrderService,private productService:ProductService,private supplierService:SupplierService) { }

  ngOnInit(): void {
    this.getOrders()
    this.getProducts()
    this.getSuppliers()
  }

  public addOrder(productId:string,supplierId:string):void{
    this.service.addOrder(+productId,+supplierId)

  }

  public getProducts():void{
    this.productService.getProducts().subscribe(response =>{
      this.products = <[Products]>response;
      console.log(this.orders);

    })

  }
  public getSuppliers():void{
    this.supplierService.getSupplier().subscribe(response =>{
      this.suppliers = <[Supplier]>response;
      console.log(this.orders);

    })

  }
  public getOrders():void{
    this.service.getOrders().subscribe(response =>{
      this.orders = <[Order]>response;
      console.log(this.orders);

    })

  }
  public delete(id:number):void{
    this.service.delete(id);

  }

}
