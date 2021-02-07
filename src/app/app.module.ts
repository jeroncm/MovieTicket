import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieEditComponent } from './movie/movie-edit/movie-edit.component';
import { MovieInfoComponent } from './movie/movie-info/movie-info.component';
import { MovieMenuComponent } from './movie/movie-menu/movie-menu.component';
import { MovieSearchComponent } from './movie/movie-search/movie-search.component';
import { FavouriteListComponent } from './favourites/favourite-list/favourite-list.component';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    MovieEditComponent,
    MovieInfoComponent,
    MovieMenuComponent,
    MovieSearchComponent,
    FavouriteListComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
