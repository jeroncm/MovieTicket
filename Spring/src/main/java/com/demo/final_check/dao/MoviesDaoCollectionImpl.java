package com.demo.final_check.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.demo.final_check.model.MovieList;


@Component
public class MoviesDaoCollectionImpl implements MoviesDao{
	
	MoviesDaoCollectionImpl(){
		if(movieList == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("final_check.xml");
			movieList = (ArrayList <MovieList>) context.getBean("movieList");
		}
	}
	
	
	
	
	
	private MovieList searchItem  = null;
public static ArrayList<MovieList> movieList;
private static final Logger LOGGER = LoggerFactory.getLogger(MoviesDaoCollectionImpl.class);


public  ArrayList<MovieList> getAllMovies(){
	LOGGER.info("inside get all movies ");
	
	return  movieList;
}


@Override
public List<MovieList> getMovieListAdmin() {
	LOGGER.info("inside get all movielist ");
	
	return  movieList;
}


@Override
public List<MovieList> getMovieListCustomer() {
	// TODO Auto-generated method stub
//	LOGGER.info("inside get all menu item ");
//	ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
//	menuItemList = (ArrayList <MenuItem>) context.getBean("menuItemList");
//	
	 ArrayList movieListCust = new ArrayList();
	 for(MovieList movie : movieList) {
		 if(movie.getDateoflaunch().before(new Date())&&movie.isActive()) {
			 movieListCust.add(movie);
		 }
	 }
	
	return  movieListCust;
}


@Override
public void modifyMovies(MovieList movie) {
	searchItem = getMovies(movie.getId());
	int indexOfSearchItem = movieList.indexOf(searchItem);
	movieList.set(indexOfSearchItem, movie);
	LOGGER.info(movie.getTitle());
	
}


@Override
public MovieList getMovies(long movieId) {
	for(MovieList movie : movieList) {
		if(movie.getId() == movieId) {
			searchItem = movie;
			LOGGER.info("aa"+searchItem);
			return searchItem;
			
		}
	}
	LOGGER.info("bb"+searchItem);
	return searchItem;
}




}
