import { Injectable } from '@angular/core';
import { UserList } from './userlist';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  user:UserList[]=[{username:"root",firstname:"admin",lastname:"admin",password:"root",confirm_password:"root"},
  {username:"john",firstname:"admin",lastname:"admin",password:"john",confirm_password:"root"},
];
  constructor(public service:AuthenticationService,public httpClient:HttpClient) { }
  
  adduser(newuser:UserList){
    this.user.push(newuser);
    //console.log(newuser);
  }

  getAllUser(){
    return this.user;
  }

  getUser(username:string): UserList{
    for(let userlist of this.user){
      if(userlist.username==username){
        return userlist;
      }
      else{
      }
    }
  }


  baseUrl = environment.baseUrl;

  addUserCustomer(useradd:UserList){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':'Bearer '+ this.service.getToken(),
        
      })
    
      
    };
  console.log("inside addusr");
    return this.httpClient.post<void>(this.baseUrl+"/users",useradd,httpOptions);
  
    
  }




}
