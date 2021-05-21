package com.mhd.filmkitapligi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mhd.filmkitapligi.model.Film;
import com.mhd.filmkitapligi.service.FilmService;

@Controller
public class FilmController {

	
	@Autowired
	private FilmService filmService;
	
	
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("listFilmler", filmService.getAllFilmler());
		return "index";
	}
	
	
	@GetMapping("/yeniFilmEkle")
	public String yeniFilmEklePage(Model model) {
		Film film = new Film();
		model.addAttribute("filmler", film);
		return "yeni_film";	
	}
	
	
	@PostMapping("/saveFilm")
	public String kaydetFilmPage(@ModelAttribute("filmler") Film film) {
		
		filmService.saveFilm(film);
		return "redirect:/";
	}
	
	
	@GetMapping("/filmGuncelle/{id}")
	public String filmGuncellePage(@PathVariable ( value = "id") long id, Model model) {
		
		
		Film film = filmService.getFilmById(id);
		model.addAttribute("filmler", film);
		return "guncelle_film";
	}
	
	
	
	@GetMapping("/filmAyrintilari/{id}")
	public String filmAyrintilari(@PathVariable ( value = "id") long id, Model model) {
		
		model.addAttribute("listFilmler", filmService.getFilmById(id));
		return "ayrintilar";
	}
	
	
	
	@GetMapping("/filmSil/{id}")
	public String deleteFilm(@PathVariable (value = "id") long id) {
		
		this.filmService.deleteFilmById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Film> page = filmService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Film> listFilmler = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listFilmler", listFilmler);
		return "index";
	}
	
	
}
