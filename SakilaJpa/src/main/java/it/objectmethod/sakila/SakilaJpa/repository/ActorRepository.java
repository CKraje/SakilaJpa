package it.objectmethod.sakila.SakilaJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.objectmethod.sakila.SakilaJpa.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor,Integer>{

		public List<Actor> findByLastNameStartingWith(String lastName);
}
