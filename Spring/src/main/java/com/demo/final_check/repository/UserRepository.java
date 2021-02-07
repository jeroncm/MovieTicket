package com.demo.final_check.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.final_check.model.UserDb;


@Repository
public interface UserRepository extends JpaRepository<UserDb, Integer>{
	UserDb findByUsername(String username);
	
	@Query(value = "SELECT COUNT(f.fv_pr_id) AS favourites_count FROM finalcheck_v2.movie_list AS m  INNER JOIN finalcheck_v2.favourites AS f ON m.mo_id = f.fv_pr_id INNER JOIN finalcheck_v2.user AS u ON f.fv_us_id = u.us_id WHERE u.us_id = ?" , nativeQuery = true)
    Double getCartTotalPrice(int userId);

}
