package com.demo.final_check.dao;

import com.demo.final_check.exception.FavouritesEmptyException;
import com.demo.final_check.model.Favourites;

public interface FavouritesDao {
	public void addFavourites(String userName, long movieId);

	public Favourites getAllFavourites(String userName) throws FavouritesEmptyException;

	public void removeFavourites(String userId, long movieId);
}
