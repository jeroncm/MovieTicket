import { Component, OnInit } from '@angular/core';
import { FavouritesServiceService } from '../favourites-service.service';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { Favourites } from '../favourites';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/service/movie.service';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { Movies } from 'src/app/movie/movie';

@Component({
  selector: 'app-favourite-list',
  templateUrl: './favourite-list.component.html',
  styleUrls: ['./favourite-list.component.css']
})
export class FavouriteListComponent implements OnInit {
remove:boolean = false;

  constructor(private favservice:FavouritesServiceService,private authservice:AuthServiceService,private router:Router,private menuser:MovieService,private auth:AuthenticationService) { }
//displayfavourites:Favourites;
iscustomer:boolean = this.authservice.isAdmin();
admin:string = this.auth.getName();
total:number;
username:string = this.auth.getName();
islogged:boolean;
displayfavourites:Movies[];
data:any;
  ngOnInit() {
    // this.islogged = this.authservice.isLogged();
    // console.log(this.islogged);
    
    // this.displayfavourites = this.favservice.getfavourites();
    this.menuser.showFavourites(this.admin).subscribe(data1=>{
      this.data = data1;
      console.log(this.data.movieList);
      
    //   this.displayfavourites = data.movieList;
    //   console.log(this.displayfavourites);
    //  // console.log(this.food.name);
      
    //   console.log();
      
    //   this.total = data.total;
    // console.log(this.total);
    
    })
  }
  removeFavourites(id:number){
// this.favservice.removefavourites(id);
this.remove=true;
this.menuser.removeFavourites(this.admin,id).subscribe(()=>this.menuser.showFavourites(this.admin).subscribe(data1=>{
  this.data = data1;
  // this.displayfavourites = data.movieList;
  // console.log(this.displayfavourites);


  // this.total = data.total;
  
  // console.log(this.total);
}))
}
  logout(){
    // this.authservice.logout();
    this.auth.logout();
    this.router.navigateByUrl('/login')
    // this.favservice.clearcart();
  }

}
