import { Injectable } from '@angular/core';
import { Favourites } from './favourites';
import {Movies} from '../movie/movie'

@Injectable({
  providedIn: 'root'
})
export class FavouritesServiceService {
empty:boolean = true;
  favourites:Favourites = {
  fav:[],
  total:0

}


clearcart(){
  this.favourites = {
    fav:[],
    total:0
  }
}

getfavourites(){
  return this.favourites;
}

addToFav(favo:Movies){
  this.favourites.fav.push(favo);
  this.favcalc(favo.count);
  console.log(this.favourites);
  
}


favcalc(total:number) {
  this.favourites.total++;
}

removefavourites(id:number) {
  const index = this.favourites.fav.findIndex(x=>x.id==id)
  const itemtoremove = this.favourites.fav.splice(index,1)[0];
  this.favourites.total--;
  if(this.favourites.total==0){
return this.empty=true;
  }
}


  constructor() { }
}
