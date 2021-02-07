import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MovieSearchComponent} from './movie/movie-search/movie-search.component'
import { LoginComponent } from './site/login/login.component';
import {SignupComponent} from './site/signup/signup.component';
import {FavouriteListComponent} from './favourites/favourite-list/favourite-list.component'
import {MovieEditComponent} from './movie/movie-edit/movie-edit.component'
import {AuthServiceGuard } from './site/auth-service.guard'


const routes: Routes = [
{path : 'movie-search',component: MovieSearchComponent},
{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},
{path:'favourite-list',component:FavouriteListComponent,canActivate:[AuthServiceGuard]},//canActivate:[AuthServiceGuard]
{path:'movie-edit',component:MovieEditComponent},
{path:'movie-edit/:id',component:MovieEditComponent},
{path:'', redirectTo:'movie-search',pathMatch : "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
