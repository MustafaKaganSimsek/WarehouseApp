import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProductListComponent } from './product-list/product-list.component';
import { CategoryPageComponent } from './category-page/category-page.component';

const routes: Routes=[
  {path: '', component: UserLoginComponent },
  {path:'products',component: ProductListComponent},
  {path:'categories', component:CategoryPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule { }
