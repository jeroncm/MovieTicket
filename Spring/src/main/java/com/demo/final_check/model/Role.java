package com.demo.final_check.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ro_id")
	int id;
	@Column(name = "ro_name")
	@NotNull
	String name;
	
	 @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER)
	    private Set<UserDb> userList;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(@NotNull int id, @NotNull String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
