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
@Table(name="film")
public class Film {

	@GeneratedValue
	@Id
	@Column(name="film_id")
	private int filmId;

	@Column(name="title")
	private String title;

	@Column(name="release_year")
	private int releaseYear;

	@Column(name="description")
	private String description;

	@ManyToMany
	@JoinTable(name="film_actor",
	joinColumns =@JoinColumn(name = "film_id"),
	inverseJoinColumns = @JoinColumn(name="actor_id"))
	
	private List<Actor> listActor= new ArrayList<Actor>();

	@ManyToMany
	@JoinTable(name="film_category",joinColumns =@JoinColumn(name = "film_id"),
	inverseJoinColumns = @JoinColumn(name="category_id"))
	
	public List<Category> categoryList;

	public int getId() {
		return filmId;
	}

	public void setId(int id) {
		this.filmId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Actor> getListActor() {
		return listActor;
	}

	public void setListActor(List<Actor> listActor) {
		this.listActor = listActor;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
}
