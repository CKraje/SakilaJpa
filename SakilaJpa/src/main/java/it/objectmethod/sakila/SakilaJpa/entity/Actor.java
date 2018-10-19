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
@Table(name="actor")
public class Actor  {

	@GeneratedValue
	@Id
	@Column(name="actor_id")
	private int actorId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;


	@ManyToMany
	@JoinTable(name="film_actor",joinColumns=@JoinColumn(name="actor_id"),
	inverseJoinColumns = @JoinColumn(name="film_id"))

	private List<Film> listFilm;


	public int getId() {
		return actorId;
	}


	public void setId(int id) {
		this.actorId = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Film> getListFilm() {
		return listFilm;
	}


	public void setListFilm(List<Film> listFilm) {
		this.listFilm = listFilm;
	}	
}
