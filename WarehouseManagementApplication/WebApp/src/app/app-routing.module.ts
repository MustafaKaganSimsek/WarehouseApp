import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProductListComponent } from './product-list/product-list.component';
import { CategoryPageComponent } from './category-page/category-page.component';
import { ProductAddFormComponent } from './product-add-form/product-add-form.component';
import { ProductFilterFormComponent } from './product-filter-form/product-filter-form.component';

const routes: Routes=[
  {path: '', component: UserLoginComponent },
  {path:'products',component: ProductListComponent,
    children:[
      {path:'add',component: ProductAddFormComponent},
      {path:'filter',component:ProductFilterFormComponent}
    ]  
  },
  {path:'categories', component:CategoryPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule { }
