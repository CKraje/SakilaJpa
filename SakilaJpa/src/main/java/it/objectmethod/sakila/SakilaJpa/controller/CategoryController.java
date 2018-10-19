package it.objectmethod.sakila.SakilaJpa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.sakila.SakilaJpa.entity.Category;
import it.objectmethod.sakila.SakilaJpa.repository.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;

	@RequestMapping("/categories")
	public String getAllCategories(HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<Category> listcategoriesFilms= categoryRepo.findAll();
		session.setAttribute("listaCategoriesFilms", listcategoriesFilms);
		return "films-actors";
	}
}
