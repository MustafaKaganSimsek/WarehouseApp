import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { LoginRequest } from '../models/loginRequest';
import{ SecurityService } from '../services/security.service'
import {Router} from "@angular/router";

@Component({
  selector: 'user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  loginRequest?:LoginRequest;
  constructor(private http:HttpClient,private security:SecurityService,private router:Router) { }

  ngOnInit(): void {
  }
  login(email:string,password:string){
    this.loginRequest={
      email:email,
      password:password
    }
    this.security.generateToken(this.loginRequest);
    this.router.navigate(["/products"])
  }
}
