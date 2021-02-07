import { Component, OnInit } from '@angular/core';
import { Movies } from '../movie';
import { MovieServiceService } from '../movie-service.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { Router } from '@angular/router';
import { FavouritesServiceService } from 'src/app/favourites/favourites-service.service';
import { MovieService } from 'src/app/service/movie.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-movie-search',
  templateUrl: './movie-search.component.html',
  styleUrls: ['./movie-search.component.css']
})
export class MovieSearchComponent implements OnInit {
  movie: Movies[];
  searchtext: string='';
  active:boolean = true;
  islogged:boolean = false;
  username:string = this.authservice.getUserName();
  iscustomer:boolean;
admin:boolean = this.authservice.isAdmin();
movielist:Movies[];

role:string = this.auth.getRole();
name:string = this.auth.getName();

date:Date=new Date();

  constructor(public movieservice:MovieServiceService,public authservice:AuthServiceService,public router:Router,public favservice:FavouritesServiceService,public movservice:MovieService,private auth:AuthenticationService) { }
search() {
  //this.movie = this.movieservice.getallmovies3(this.searchtext);
  this.movservice.getAllMovies().subscribe(movielist=>{this.movielist=movielist;
    this.movielist=this.movielist.filter(x=>x.title.toLowerCase().indexOf(this.searchtext.toLowerCase())!==-1);});
}

search1() {
  // this.movie=this.movieservice.getmovies(this.searchtext,this.active,this.date);
  // console.log(this.movie);
  this.movservice.getAllMovies().subscribe(movielist=>{this.movielist=movielist;
    this.movielist=this.movielist.filter(x=>x.title.toLowerCase().indexOf(this.searchtext.toLowerCase())!==-1);});
  
}
  ngOnInit() {
console.log(this.role);
console.log(this.name);

if(this.role == "USER" ||this.role == "ADMIN"){
  this.islogged = true;
  console.log("islogged value :" + this.islogged);
  
}

if(this.role == "ADMIN"){
this.iscustomer = true;
}

    //this.islogged = this.authservice.isLogged();
    //console.log(this.islogged);


   // this.movservice.getAllMovies().subscribe(movielist=>{this.movielist = movielist;})
    //console.log(this.admin);
    
    
  }

  logout(){
    // this.authservice.logout();
    this.auth.logout();
    this.router.navigateByUrl('/login');
    // this.favservice.clearcart();
  }

}
