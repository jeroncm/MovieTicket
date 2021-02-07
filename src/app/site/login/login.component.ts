import { Component, OnInit } from '@angular/core';
import { UserList } from '../userlist';
import { AuthServiceService } from '../auth-service.service';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
loggeduser:UserList;
error: boolean = true;
authenticated:boolean=true;
  constructor(private service: AuthServiceService,public router: Router,private authservice: AuthenticationService) { }

  ngOnInit() {
    this.loggeduser={
      username:"",
      firstname:"",
      lastname:"",
      password:"",
      confirm_password:""
    }
  }
  // onlogin(){
  //   console.log(this.loggeduser.username);
  //   this.authenticated=this.service.authenticateUser(this.loggeduser.username,this.loggeduser.password);
  //   if(this.authenticated) {
  //     this.router.navigateByUrl('/movie-search');
  //   }
  //   else this.router.navigateByUrl('/login');

  // }


  onlogin() {

    console.log("hi");
    
    let authResult = this.authservice.authenticate(this.loggeduser.username,this.loggeduser.password);
    authResult.subscribe(
      data => {
        console.log("success");
        
       this.authservice.setToken(data.token);
      this.authservice.setName(data.user)

      this.authservice.setRole(data.role)
       this.router.navigateByUrl('/movie-search');
      },
      err=>{
        console.log("in error");
        
        this.authenticated = false;
        if(err.status == 401){
          this.error = false;
        }
      }
    );
    }

}
