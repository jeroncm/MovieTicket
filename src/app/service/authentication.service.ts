import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private authenticationApiUrl = 'http://localhost:8053/authentication-service/authenticate';
  private token: string;
  user: string;
  name:string =  "anon";
  constructor(private httpClient: HttpClient) { }


  authenticate(user: string, password: string): Observable<any>{
    let credentials = btoa(user+':'+password);
    // console.log(credentials);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization','Basic ' + credentials);
    return this.httpClient.get(this.authenticationApiUrl, {headers});
  }
  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }

  public setName(user: string) {
    this.user = user;
  }
  public getName() {
    console.log(this.user);
    return this.user;
   
    
  }

  

public setRole(user:string)
{
this.name = user;
}

public getRole(){
  return this.name;
}
logout(){

  console.log("inside lgout");
  this.name = "";
  this.user = "";
  this.token = "";
}

guard(){
  if(this.name == "user"|| this.name == "anon"){
    return false;
  }
  else{
    return true;
  }
}
}
