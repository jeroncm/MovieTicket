package com.demo.final_check.dao;

import java.util.List;

import com.demo.final_check.model.MovieList;


public interface MoviesDao {
	
	public List<MovieList> getMovieListAdmin();

	public List<MovieList> getMovieListCustomer();

	public void modifyMovies(MovieList menuItem);

	public MovieList getMovies(long menuItemId);

}
