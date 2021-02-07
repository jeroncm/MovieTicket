package com.demo.final_check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.final_check.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findById(int id);
	
	
	
}
