package it.objectmethod.sakila.SakilaJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.sakila.SakilaJpa.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer>{
	
	public List<Film> findByTitleStartingWith(String name);	
}
