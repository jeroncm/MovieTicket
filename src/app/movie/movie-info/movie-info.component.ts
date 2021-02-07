import { Component, OnInit, Input } from '@angular/core';
import { Movies } from '../movie';
import { MovieServiceService } from '../movie-service.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { FavouritesServiceService } from 'src/app/favourites/favourites-service.service';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/service/movie.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-movie-info',
  templateUrl: './movie-info.component.html',
  styleUrls: ['./movie-info.component.css']
})
export class MovieInfoComponent implements OnInit {
  
  added:boolean = false;

  @Input()
movielist:Movies[];
  movie: any;
  searchtext: string='';
  role:string = this.auth.getRole();
name:string = this.auth.getName();
  isAdmin:boolean = false;
  constructor(public movieservice:MovieServiceService ,private auth:AuthenticationService, public authservice:AuthServiceService,public movservice:MovieService,public favservice:FavouritesServiceService,public router:Router) { }

  ngOnInit() {
    if(this.role == "ADMIN"){
    this.isAdmin =true;
    }else{
      this.isAdmin = false;
    }


    this.movservice.getAllMovies().subscribe(movielist=>{this.movielist=movielist;
      this.movielist=this.movielist.filter(x=>x.title.toLowerCase().indexOf(this.searchtext.toLowerCase())!==-1);});
    
//     this.isAdmin = this.authservice.isAdmin();
//     if(this.isAdmin){
// this.movielist = this.movieservice.getallmovies1();
// console.log(this.movielist);
//     }else{
//       this.movielist = this.movieservice.getallmovies();
//     }


  }

addToFavourites(movie:Movies) {
  // if(this.authservice.isLogged()){
  //   this.favservice.addToFav(movie);
  //   this.added = true;
  // }else {
  //         this.router.navigateByUrl('/login');
  // }


  if(this.role == "USER"){
    
     this.movservice.addtofavourites(this.name,movie.id).subscribe();
     console.log("insisde add to cart");
     
     // this.service.addToCart(item);
     this.added=true;
    }else{
      this.router.navigateByUrl('/login');
    }

}


}
