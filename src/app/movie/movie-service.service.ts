import { Injectable } from '@angular/core';
import { Movies } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {
filtermovies:Movies[];

  movies:Movies[] = [
// {id:1,title:"Avatar",boxoffice:2787965087,genre:"Science-fiction",active:true,hasteaser:false,dateoflaunch:new Date("3/15/2019"),url:"https://pmcvariety.files.wordpress.com/2013/07/avatar.jpg?w=1000",count:1},
// {id:2,title:"Avengers",boxoffice:2787965087,genre:"Superhero",active:true,hasteaser:true,dateoflaunch:new Date("7/25/2017"),url:"https://www.avsforum.com/wordpress/wp-content/uploads/2019/07/Avengers-Endgame-Header-Pic-1000x562.png",count:1},
// {id:3,title:"Titanic",boxoffice:2787965087,genre:"Romance",active:true,hasteaser:true,dateoflaunch:new Date("1/8/2017"),url:"https://titanicsound.files.wordpress.com/2014/11/titanic_movie-hd-1.jpg",count:1},
// {id:4,title:"Jurassic world",boxoffice:1671713208,genre:"Science-fiction",active:false,hasteaser:true,dateoflaunch:new Date("11/2/2017"),url:"https://cdn1.thr.com/sites/default/files/2017/12/jurassic_world_fallen_kingdom_0.jpg",count:1},
// {id:5,title:"Endgame",boxoffice:2750760348,genre:"Superhero",active:false,hasteaser:false,dateoflaunch:new Date("2/11/2022"),url:"https://cdn.mos.cms.futurecdn.net/pGGqwmB4zPkiLZd66zUH76.jpg",count:1}
  ]
  movie: Movies[];

 getallmovies(active:boolean=true,date:Date=new Date()) {
   let moviefilter = this.movies.filter(x=>x.active==active && x.dateoflaunch<date)
   return moviefilter;
   }

  getallmovies1() {
    return this.movies
  }

  getallmovies2(search:string) {
    console.log(this.movies);
    let filtermovies = this.movies.filter(x=>x.title.toLowerCase().indexOf(search.toLowerCase())!==-1)
console.log(filtermovies);
 return filtermovies

  }


  getallmovies3(search:string) {
    console.log("inside 3");
    let filtermovies = this.movies.filter(x=>x.title.toLowerCase().indexOf(search.toLowerCase())!==-1)
    return filtermovies;
    

  }

  getmovies(search:string,active:boolean,date:Date){
    this.movie=this.movies.filter(x=>x.active==active && x.dateoflaunch<=date);
    this.movie=this.movie.filter(x=>x.title.toLowerCase().indexOf(search.toLowerCase())!==-1);
return this.movie;
  }

  getFavById(id:number):Movies{
    for(let list of this.movies)
    {
      if(list.id==id)
      {
        return list;
      }
    }return null;

  }

  updatemovies(editmovie:Movies){
for(var list of this.movies){
  if(list.id==editmovie.id){
    list.title=editmovie.title;
    list.boxoffice=editmovie.boxoffice;
    list.active=editmovie.active
    list.dateoflaunch = new Date(editmovie.dateoflaunch);
    list.genre = editmovie.genre;
    list.hasteaser= editmovie.hasteaser;

  }
} return list;
  }





  constructor() { }
}

