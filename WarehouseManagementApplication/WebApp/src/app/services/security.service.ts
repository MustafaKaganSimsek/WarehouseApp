import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../models/loginRequest';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  url = "http://localhost:8080/auth";
  
  loginRequest?:LoginRequest;
  constructor(private http:HttpClient) { }

  

  public generateToken(request:LoginRequest) {
    
    this.http.post(this.url+"/login",request,{responseType: 'text' as 'json'}).subscribe({
      next:(token) =>{
        localStorage.setItem("token",'Bearer '+token);
        console.log(token);
        return '200';
      },
      error:(err)=>{
        
        console.log(err.status);
        return err.status;
      }
      
    });  
  }

  public getHeaders(){
    console.log(localStorage.getItem('token')+"sdsdgsd");
    
    return new HttpHeaders().set('Authorization',<string>localStorage.getItem('token'));
  }
}
