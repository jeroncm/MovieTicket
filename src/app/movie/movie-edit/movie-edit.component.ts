import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthServiceService } from 'src/app/site/auth-service.service';
import { MovieServiceService } from '../movie-service.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Favourites } from 'src/app/favourites/favourites';
import { Movies } from '../movie';
import { FavouritesServiceService } from 'src/app/favourites/favourites-service.service';
import { MovieService } from 'src/app/service/movie.service';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-movie-edit',
  templateUrl: './movie-edit.component.html',
  styleUrls: ['./movie-edit.component.css']
})
export class MovieEditComponent implements OnInit {
  editForm:FormGroup;
movieId = this.route.snapshot.paramMap.get("id");
fav:Movies;
editted:boolean=false;
  favouriteslist: any;
  constructor(public route: ActivatedRoute,public menu:MovieService,public authservice:AuthServiceService,public movieservice:MovieServiceService,public router:Router,public favservice:FavouritesServiceService,public auths:AuthenticationService) { }

  ngOnInit() {
    let fid = Number(this.movieId);
    //this.fav = this.movieservice.getFavById(fid);

this.menu.getMovies(fid).subscribe(data=>{
  console.log(data);
  this.favouriteslist = data;
  
  this.editForm = new FormGroup({
    'title' : new FormControl(this.favouriteslist.title, [
      Validators.required,
      Validators.minLength(2),
      Validators.maxLength(20)
    ]),
    'boxoffice' : new FormControl(this.favouriteslist.boxoffice, [
      Validators.required,
      Validators.pattern("^[0-9]*$")
    ]),
    'dateoflaunch' : new FormControl(this.favouriteslist.dateoflaunch, [
      Validators.required,
    ]),
    'active' : new FormControl(this.favouriteslist.active, [
      Validators.required,
    ]),
    'url' : new FormControl(this.favouriteslist.url, [
      Validators.required,
    ]),
    'genre' : new FormControl(this.favouriteslist.genre, [
      Validators.required,
    ]),
    'hasteaser' : new FormControl(this.favouriteslist.hasteaser, [
    ]),
  });

  this.editForm.get('title').valueChanges.subscribe(value=>this.favouriteslist.title=value);
  this.editForm.get('boxoffice').valueChanges.subscribe(value=>this.favouriteslist.boxoffice=value);
  this.editForm.get('dateoflaunch').valueChanges.subscribe(value=>this.favouriteslist.dateoflaunch=value);
  this.editForm.get('active').valueChanges.subscribe(value=>this.favouriteslist.active=value);
  this.editForm.get('url').valueChanges.subscribe(value=>this.favouriteslist.url=value);
  this.editForm.get('genre').valueChanges.subscribe(value=>this.favouriteslist.genre=value);
  this.editForm.get('hasteaser').valueChanges.subscribe(value=>this.favouriteslist.hasteaser=value);
})





    // this.editForm = new FormGroup({
    //   'title' : new FormControl(this.fav.title, [
    //     Validators.required,
    //     Validators.minLength(2),
    //     Validators.maxLength(20)
    //   ]),
    //   'boxoffice' : new FormControl(this.fav.boxoffice, [
    //     Validators.required,
    //     Validators.pattern("^[0-9]*$")
    //   ]),
    //   'dateoflaunch' : new FormControl(this.fav.dateoflaunch, [
    //     Validators.required,
    //   ]),
    //   'active' : new FormControl(this.fav.active, [
    //     Validators.required,
    //   ]),
    //   'url' : new FormControl(this.fav.url, [
    //     Validators.required,
    //   ]),
    //   'genre' : new FormControl(this.fav.genre, [
    //     Validators.required,
    //   ]),
    //   'hasteaser' : new FormControl(this.fav.hasteaser, [
    //   ]),
    // });

    // this.editForm.get('title').valueChanges.subscribe(value=>this.fav.title=value);
    // this.editForm.get('boxoffice').valueChanges.subscribe(value=>this.fav.boxoffice=value);
    // this.editForm.get('dateoflaunch').valueChanges.subscribe(value=>this.fav.dateoflaunch=value);
    // this.editForm.get('active').valueChanges.subscribe(value=>this.fav.active=value);
    // this.editForm.get('url').valueChanges.subscribe(value=>this.fav.url=value);
    // this.editForm.get('genre').valueChanges.subscribe(value=>this.fav.genre=value);
    // this.editForm.get('hasteaser').valueChanges.subscribe(value=>this.fav.hasteaser=value);


  }
  logout(){
    // this.authservice.logout();
    this.auths.logout();
    this.router.navigateByUrl('/login')
    // this.favservice.clearcart();
  }

onsubmit()
{
  // this.movieservice.updatemovies(this.fav);
  // this.editted = true;
  // console.log(this.editted);
  this.menu.modifyMovies(this.favouriteslist).subscribe();
  this.editted = true;
}
get title() {return this.editForm.get('title');}
get boxoffice() {return this.editForm.get('boxoffice');}
get dateoflaunch() {return this.editForm.get('dateoflaunch');}
get active() {return this.editForm.get('active');}
get url() {return this.editForm.get('url');}
get genre() {return this.editForm.get('genre');}
get hasteaser() {return this.editForm.get('hasteaser');}


}
