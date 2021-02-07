package com.demo.final_check.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.final_check.dao.MoviesDaoCollectionImpl;
import com.demo.final_check.model.MovieList;
import com.demo.final_check.repository.MovieListRepository;


@Service
public class MovieService {
private MoviesDaoCollectionImpl menuItemDao;
private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

public  MovieService() {
	super();
	LOGGER.info("creating movieservice using default constructor");
}


@Autowired
public void setMoviesDao(MoviesDaoCollectionImpl menuItemDao) {
	this.menuItemDao = menuItemDao;
}

@Autowired
MovieListRepository movieListRepository;

@Transactional
public ArrayList<MovieList> getAllMovies(){
	return (ArrayList<MovieList>) movieListRepository.getMovies();
}

@Transactional
public ArrayList<MovieList> getAllMoviesAdmin(){
	return (ArrayList<MovieList>) movieListRepository.findAll();
}

@Transactional
public MovieList getMovies(int id) {
	LOGGER.info("inside id serv");
	LOGGER.info("inside id serv"+id);
	return movieListRepository.findById(id).get();
	
}


@Transactional
public void modifyMovies(MovieList movies) {
	LOGGER.info(movies.getTitle());
	movieListRepository.save(movies);
	
}

}
