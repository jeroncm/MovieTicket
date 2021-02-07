import { Injectable } from '@angular/core';
import { UserServiceService } from './user-service.service';
import { UserList } from './userlist';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  loggedusername: string;
  loggedInUser: boolean = false;
  adminflag: boolean;
  user:UserList[];

  constructor(private service:UserServiceService) { }
  getUserName(){
    return this.loggedusername;
  }
  logout(){
    this.loggedInUser=false;
    this.adminflag=false;
  }

  isLogged(){
    return this.loggedInUser;
  }

  authenticateUser(username:string,password:string){
    this.user=this.service.getAllUser();
    var flag:boolean;
    for(let user of this.user){
      if(user.username==username && user.password==password){
      flag=true;
      break;
      }
      else{
        flag=false;
      }
    }
  
  
    if(username=='root' && password=='root'){
      this.adminflag=true;
    }
    else{
      this.adminflag=false;
    }
    if(flag){
      this.loggedusername=username;
  this.loggedInUser=true;
      return true;
    }
    else{
      return false;
    }
    }
    isAdmin(){
      return this.adminflag;
    }

}
