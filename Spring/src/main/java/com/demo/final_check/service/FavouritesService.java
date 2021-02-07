package com.demo.final_check.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.final_check.dao.FavouritesDaoCollectionImpl;
import com.demo.final_check.model.Favourites;
import com.demo.final_check.model.MovieList;
import com.demo.final_check.model.UserDb;
import com.demo.final_check.repository.MovieListRepository;
import com.demo.final_check.repository.UserRepository;





@Service
public class FavouritesService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FavouritesService.class);
//private FavouritesDaoCollectionImpl favouritesDao;
//	@Autowired
//	public void setMoviesDao(FavouritesDaoCollectionImpl favouritesDao) {
//		this.favouritesDao = favouritesDao;
//	}
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MovieListRepository movieListRepository;
	
	@Transactional
	public void addFavourites(String userName, long movieId) {
		//favouritesDao.addFavourites(userName, menuItemId);
		
		
		UserDb user = userRepository.findByUsername(userName);
		
		MovieList movie = movieListRepository.findById((int) movieId).get();
		
		if(movie!=null) {
			List<MovieList> movieList = user.getMovieList();
			movieList.add(movie);
			user.setMovieList(movieList);
			userRepository.save(user);
			
		}
		
		
		
	}
	//private CartDao cartDao = new CartDaoCollectionImpl();
	
	@Transactional
	public Favourites showFavourites(String userId) {
//		LOGGER.info("service"+userId);
//		try {
//			return favouritesDao.getAllFavourites(userId);
//			
//		} catch (FavouritesEmptyException e) {
//			e.printStackTrace();
//		}
//		return null;
		
		UserDb user = userRepository.findByUsername(userId);
		Favourites favourites = new Favourites();
		
		try {
			List<MovieList> movieList = user.getMovieList();
			favourites = new Favourites();
			favourites.setMovieList(movieList);
			
			int id = user.getUserId();
			double total = userRepository.getCartTotalPrice(id);
			favourites.setTotal(total);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return favourites;
		
		
		
		
		
		
	}
	
	public void deleteFavourites(String userId,int id) {
		//favouritesDao.removeFavourites(userId, id);
		
		
UserDb user = userRepository.findByUsername(userId);
		
		MovieList movie = movieListRepository.findById((int) id).get();
		
		if(movie!=null) {
			List<MovieList> movieList = user.getMovieList();
			movieList.remove(movie);
			user.setMovieList(movieList);
			userRepository.save(user);
			
		}
		
		
	}
	
}