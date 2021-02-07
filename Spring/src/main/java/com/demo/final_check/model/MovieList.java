package com.demo.final_check.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "movie_list")
public class MovieList {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "mo_id")
	private int id;
@Column(name = "mo_title")
	private String title;
@Column(name = "mo_box_office")
	private long boxoffice;
@Column(name = "mo_active")
	private boolean active;
@Column(name = "mo_date_of_launch")
	private Date dateoflaunch;
@Column(name = "mo_genre")
	private String genre;
@Column(name = "mo_has_teaser")
	private boolean hasteaser;
@Column(name = "mo_url")
	private String url;
	public MovieList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieList(int id, String title, long boxoffice, boolean active, Date dateoflaunch, String genre,
			boolean hasteaser, String url) {
		super();
		this.id = id;
		this.title = title;
		this.boxoffice = boxoffice;
		this.active = active;
		this.dateoflaunch = dateoflaunch;
		this.genre = genre;
		this.hasteaser = hasteaser;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getBoxoffice() {
		return boxoffice;
	}
	public void setBoxoffice(long boxoffice) {
		this.boxoffice = boxoffice;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getDateoflaunch() {
		return dateoflaunch;
	}
	public void setDateoflaunch(Date dateoflaunch) {
		this.dateoflaunch = dateoflaunch;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isHasteaser() {
		return hasteaser;
	}
	public void setHasteaser(boolean hasteaser) {
		this.hasteaser = hasteaser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "MovieList [id=" + id + ", title=" + title + ", boxoffice=" + boxoffice + ", active=" + active
				+ ", dateoflaunch=" + dateoflaunch + ", genre=" + genre + ", hasteaser=" + hasteaser + ", url=" + url
				+ "]";
	}
	
	
	
	
}
