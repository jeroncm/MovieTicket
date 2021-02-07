package com.demo.final_check.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.final_check.exception.FavouritesEmptyException;
import com.demo.final_check.model.Favourites;
import com.demo.final_check.model.MovieList;


@Component
public class FavouritesDaoCollectionImpl implements FavouritesDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(FavouritesDaoCollectionImpl.class);
	private static HashMap<String, Favourites> userCarts;
	private List<MovieList> movieList = null;
	private Favourites favourites = null;

	public FavouritesDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Favourites>();

		}
	}

	@Override
	public void addFavourites(String userName, long movieId) {
		MoviesDao menuItemDao = new MoviesDaoCollectionImpl();
		MovieList menuItem = menuItemDao.getMovies(movieId);

		favourites = userCarts.get(userName);
		if (favourites != null) {
			movieList = favourites.getMovieList();
			movieList.add(menuItem);
		} else {
			movieList = new ArrayList<MovieList>();
			favourites = new Favourites(movieList, 0.0);
			favourites.getMovieList().add(menuItem);
			userCarts.put(userName, favourites);
		}
		LOGGER.info("DaoAdd"+userCarts);

	}

	@Override
	public Favourites getAllFavourites(String userName) throws FavouritesEmptyException {
		double total;
		favourites = userCarts.get(userName);
		LOGGER.info("Dao"+userCarts);
		if (favourites != null) {
			movieList = favourites.getMovieList();
			if (movieList == null || movieList.isEmpty()) {
				//throw new CartEmptyException();
				favourites.setTotal(0.0);
			} else {
				total = 0.0;
				for (MovieList movie : movieList) {
					 total++;
				}
				favourites.setTotal(total);
			}
		}
		return favourites;
	}

	@Override
	public void removeFavourites(String userId, long moviesId) {
		favourites = userCarts.get(userId);

		movieList = favourites.getMovieList();
		int indexOfMatchingItem = 0;
		for (MovieList movie : movieList) {
			if (movie.getId() == moviesId) {
				indexOfMatchingItem = movieList.indexOf(movie);
				break;

			}
		}
		movieList.remove(indexOfMatchingItem);

	}
}