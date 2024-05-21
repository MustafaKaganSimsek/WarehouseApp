import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProductListComponent } from './product-list/product-list.component';
import { CategoryPageComponent } from './category-page/category-page.component';
import { ProductAddFormComponent } from './product-add-form/product-add-form.component';
import { ProductFilterFormComponent } from './product-filter-form/product-filter-form.component';
import {OrderListComponent} from "./order-list/order-list.component";
import {SupplierListComponent} from "./supplier-list/supplier-list.component";
import {CategoryUpdateComponent} from "./category-update/category-update.component";
import {SuppleirUpdateComponent} from "./suppleir-update/suppleir-update.component";
import {ProductUpdateComponent} from "./product-update/product-update.component";

const routes: Routes=[
  {path: '', component: UserLoginComponent },
  {path:'products',component: ProductListComponent,
    children:[
      {path:'add',component: ProductAddFormComponent},
      {path:'filter',component:ProductFilterFormComponent},
      {path:'update/:id',component:ProductUpdateComponent}
    ]
  },
  {path:'categories', component:CategoryPageComponent,
    children:[
      {path: 'update/:id',component:CategoryUpdateComponent}
    ]
  },
  {path:'orders', component:OrderListComponent},
  {path:'suppliers', component:SupplierListComponent,
    children:[
      {path: 'update/:id',component:SuppleirUpdateComponent}
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule { }
