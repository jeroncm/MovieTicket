package com.demo.final_check.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
@NotNull
int UserId;
@NotNull
String username;
@NotNull(message = "password should not be null")
@NotBlank(message = "firstname should not be blank")
@Size(max = 30 ,message = "password should be 8-30 characters")
String password;
@NotNull(message = "firstname should not be null")
@NotBlank(message = "firstname should not be blank")
String firstname;
@NotNull(message = "lastname should not be null")
@NotBlank(message = "lastname should not be blank")
String lastname;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(@NotNull int userId, @NotNull String username,
		@NotNull(message = "password should not be null") @NotBlank(message = "firstname should not be blank") @Size(max = 30, message = "password should be 8-30 characters") String password,
		@NotNull(message = "firstname should not be null") @NotBlank(message = "firstname should not be blank") String firstname,
		@NotNull(message = "lastname should not be null") @NotBlank(message = "lastname should not be blank") String lastname) {
	super();
	UserId = userId;
	this.username = username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
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
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}











}
