package com.demo.final_check.model;

import java.util.List;

public class Favourites {
	private List<MovieList> movieList;
	private double total;

	public Favourites() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favourites(List<MovieList> movieList, double total) {
		super();
		this.movieList = movieList;
		this.total = total;
//		totsl
	}

	public List<MovieList> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MovieList> menuItemList) {
		this.movieList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favourites other = (Favourites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + movieList + ", total=" + total + "]";
	}
}
