package it.objectmethod.sakila.SakilaJpa.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.sakila.SakilaJpa.entity.Actor;
import it.objectmethod.sakila.SakilaJpa.entity.Category;
import it.objectmethod.sakila.SakilaJpa.entity.Film;
import it.objectmethod.sakila.SakilaJpa.repository.ActorRepository;
import it.objectmethod.sakila.SakilaJpa.repository.CategoryRepository;
import it.objectmethod.sakila.SakilaJpa.repository.FilmRepository;

@Controller
public class FilmController {
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private FilmRepository filmRepo;
	
	@Autowired
	private ActorRepository actorRepo;

	@RequestMapping("categories-films")
	public String getFilmsByCategory(ModelMap map, @RequestParam("Genres")int id,
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("categoryId", id);
		Category category = categoryRepo.findOne(id);
		List<Film> listFilms=category.getFilmList();
				map.addAttribute("listaFilms", listFilms);
		return "forward:/categories";
	}

	@RequestMapping("actors-films")
	public String getFilmsByActor (ModelMap map,@RequestParam("actorId")int id) {
		Actor actor= actorRepo.findOne(id);
		List<Film> filmList =actor.getListFilm();
		map.addAttribute("listaFilms", filmList);
		return "films-actors";
	}

	@RequestMapping("search-films")
	public String getFilmsByName (ModelMap map,
			@RequestParam("film_Name")String filmName) {
		List<Film> filmList = filmRepo.findByTitleStartingWith(filmName);
		map.addAttribute("listaFilms", filmList);
		return "films-actors";
	}
}
