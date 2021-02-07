package com.demo.final_check.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserDb {
	
	@Id
	@Column(name = "us_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	@Column(name = "us_name")
	String username;

	@Column(name = "us_pass")
	String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "favourites", joinColumns = @JoinColumn(name = "fv_us_id"), inverseJoinColumns = @JoinColumn(name = "fv_pr_id"))
	private List<MovieList> movieList;

	public UserDb() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public UserDb(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}




	public UserDb(int userId, String username, String password, Set<Role> roleList, List<MovieList> movieList) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roleList = roleList;
		this.movieList = movieList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	public List<MovieList> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MovieList> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "UserDb [userId=" + userId + ", username=" + username + ", password=" + password + ", roleList="
				+ roleList + ", movieList=" + movieList + "]";
	}

	
	
	
}
