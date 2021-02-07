import { Component, OnInit } from '@angular/core';
import { UserList } from '../userlist';
import { UserServiceService } from '../user-service.service';
import { Router } from '@angular/router';
import { FormGroup ,FormControl,Validators} from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user:UserList={username:"",firstname:"",lastname:"",password:"",confirm_password:""};
  userForm:FormGroup;
  constructor(private service : UserServiceService,public router: Router) { }

  ngOnInit() {
    this.userForm = new FormGroup({
      'username' : new FormControl('', [
        Validators.required,
      ]),
      'firstname' : new FormControl('', [
        Validators.required,
        Validators.pattern('^[a-zA-Z\s]*$')
      ]),
      'lastname' : new FormControl('', [
        Validators.required,
        Validators.pattern('^[a-zA-Z\s]*$')
      ]),
      'password' : new FormControl('', [
        Validators.required
      ]),
      'confirm_password' : new FormControl('', [
        Validators.required
      ]),
    });
    this.userForm.get('username').valueChanges.subscribe(value=>this.user.username=value);
    this.userForm.get('firstname').valueChanges.subscribe(value=>this.user.firstname=value);
    this.userForm.get('lastname').valueChanges.subscribe(value=>this.user.lastname=value);
    this.userForm.get('password').valueChanges.subscribe(value=>this.user.password=value);
    this.userForm.get('confirm_password').valueChanges.subscribe(value=>this.user.confirm_password=value);

  }
  onSubmit(){
    // this.service.adduser(this.user);
    this.service.addUserCustomer(this.user).subscribe();
    this.router.navigateByUrl('/login');
   }
  

   get username() { return this.userForm.get('username'); }
   get firstname() { return this.userForm.get('firstname'); }
   get lastname() { return this.userForm.get('lastname'); }
   get password() { return this.userForm.get('password'); }
   get confirm_password() { return this.userForm.get('confirm_password'); }

}
