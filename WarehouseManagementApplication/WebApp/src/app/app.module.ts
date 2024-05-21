import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProductListComponent } from './product-list/product-list.component';
import { AppRoutingModule } from './app-routing.module';
import { CategoryPageComponent } from './category-page/category-page.component';
import { ProductAddFormComponent } from './product-add-form/product-add-form.component';
import { ProductFilterFormComponent } from './product-filter-form/product-filter-form.component';
import { HttpClientModule } from '@angular/common/http';
import { OrderListComponent } from './order-list/order-list.component';
import { SupplierListComponent } from './supplier-list/supplier-list.component';
import { SuppleirUpdateComponent } from './suppleir-update/suppleir-update.component';
import { CategoryUpdateComponent } from './category-update/category-update.component';
import { ProductUpdateComponent } from './product-update/product-update.component'

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UserLoginComponent,
    ProductListComponent,
    CategoryPageComponent,
    ProductAddFormComponent,
    ProductFilterFormComponent,
    OrderListComponent,
    SupplierListComponent,
    SuppleirUpdateComponent,
    CategoryUpdateComponent,
    ProductUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
