package com.demo.final_check.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.final_check.model.MovieList;
import com.demo.final_check.security.AppUserDetailsService;
import com.demo.final_check.service.MovieService;



@CrossOrigin("http://localhost:4200")

@RequestMapping("/movies")
@RestController
public class MoviesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviesController.class);
	public MovieService movieService;
@Autowired
	UserController userController;
	

@Autowired
AppUserDetailsService appUserDetailsService;
	public MoviesController() {
		super();
		LOGGER.info("creating menuitem controller using default constructor");
	}
	
	
	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("")
	public ArrayList<MovieList> getAllMovies(){
		
		
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
				String user = authentication.getName();
				if(user.equals("anonymousUser"))
					return this.movieService.getAllMovies();
				else {
				
				UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
				String role = userDetails.getAuthorities().toArray()[0].toString();
LOGGER.info(role);
LOGGER.info(user);
if(role.equals("ADMIN")) {
	return this.movieService.getAllMoviesAdmin();
}

else  {
	return this.movieService.getAllMovies();

}

				}
		
		
	}
	@GetMapping("/{id}")
	public MovieList getMovies(@PathVariable int id) {
		
		LOGGER.info("inside id");
		LOGGER.info("inside id"+id);
		return movieService.getMovies(id);
	}
	@PutMapping("")
	public void modifyMovie(@RequestBody MovieList movie) {
		
		LOGGER.info("ygguyug"+movie.getTitle());
		this.movieService.modifyMovies(movie);
	}
	
	
	
}
