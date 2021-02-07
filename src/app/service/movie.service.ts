import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { Observable } from 'rxjs';
import { Movies } from '../movie/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  baseUrl=environment.baseUrl;

  constructor(public httpClient:HttpClient,public service:AuthenticationService) { }


  public getAllMovies(): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':'Bearer '+ this.service.getToken(),
        
      })
    };
    return this.httpClient.get(environment.baseUrl+"/movies",httpOptions);
  }

  getMovies(id:number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':'Bearer '+ this.service.getToken(),
        
      })
    };
    return this.httpClient.get(`${this.baseUrl}/movies/${id}`,httpOptions);
  }

  modifyMovies(movies:Movies){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':'Bearer '+ this.service.getToken(),
        
      })
    
      
    };
    console.log(movies);
    
    return this.httpClient.put<void>(this.baseUrl+"/movies",movies,httpOptions);
  }

  addtofavourites(title:string,moviesId:number){
  
  
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':'Bearer '+ this.service.getToken(),
        
      })
    };
  return this.httpClient.post<void>(this.baseUrl+"/favourites/"+title+"/"+moviesId,moviesId,httpOptions)
  }


  removeFavourites(userName:string,id:number){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':'Bearer '+ this.service.getToken(),
        
      })
    
      
    };
  
    return this.httpClient.delete<void>(environment.baseUrl+"/favourites/"+userName+"/"+id,httpOptions)
  }

  showFavourites(name:string){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization':'Bearer '+ this.service.getToken(),
        
      })
    
      
    };
   
    
    return this.httpClient.get(this.baseUrl+"/favourites/show-favourites/"+name,httpOptions);
  }


}
