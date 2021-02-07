package com.demo.final_check.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.final_check.model.Favourites;
import com.demo.final_check.service.FavouritesService;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/favourites")
public class FavouritesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FavouritesController.class);
	
@Autowired
FavouritesService favouriteService;


@PostMapping("/{userName}/{movieId}")
public void addCartItem (@PathVariable String userName,@PathVariable long movieId) {
	this.favouriteService.addFavourites(userName, movieId);
	LOGGER.info("inside addto favourites");
}

@GetMapping("/show-favourites/{name}")
public Favourites showCarts(@PathVariable String name) {
	LOGGER.info("controller"+name);
	return favouriteService.showFavourites(name);
}
@DeleteMapping("{userId}/{id}")
public void deleteCarts(@PathVariable String userId,@PathVariable int id) {
	favouriteService.deleteFavourites(userId, id);
}


}
