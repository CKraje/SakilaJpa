package it.objectmethod.sakila.SakilaJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	@GeneratedValue
	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="name")
	private String name;

	@Column(name="last_update")
	private String lastUpdate;

	@ManyToMany
	@JoinTable(name="film_category",joinColumns =@JoinColumn(name = "category_id"),
	inverseJoinColumns = @JoinColumn(name="film_id"))
	
	public List<Film> filmList ;

	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}	
}
