package it.objectmethod.sakila.SakilaJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.sakila.SakilaJpa.entity.Actor;
import it.objectmethod.sakila.SakilaJpa.entity.Film;
import it.objectmethod.sakila.SakilaJpa.repository.ActorRepository;
import it.objectmethod.sakila.SakilaJpa.repository.FilmRepository;

@Controller
public class ActorController {

	@Autowired
	private ActorRepository actorRepo;

	@Autowired
	private FilmRepository filmRepo;


	@RequestMapping("films-actors")
	public String getActorsByFilm(ModelMap map,@RequestParam("filmId")int idFilm) {
		Film film = filmRepo.findOne(idFilm);
		List<Actor> actorList = film.getListActor();
		map.addAttribute("actorList", actorList);
		return "forward:/categories";
	}

	@RequestMapping("actors-search")
	public String getActorByLastName(ModelMap map,
			@RequestParam("actorLastName")String actorLastName) {
		List<Actor> actorList = actorRepo.findByLastNameStartingWith(actorLastName);
		map.addAttribute("actorList", actorList);
		return "films-actors";
	}
}
