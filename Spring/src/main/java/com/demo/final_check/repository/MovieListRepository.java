package com.demo.final_check.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.final_check.model.MovieList;

@Repository
public interface MovieListRepository extends JpaRepository<MovieList, Integer>{

	
	 @Query(value="SELECT * FROM finalcheck_v2.movie_list where mo_active = 1 && mo_date_of_launch <= \"2019-05-11\"", nativeQuery = true)
	    List<MovieList> getMovies();
	
}
