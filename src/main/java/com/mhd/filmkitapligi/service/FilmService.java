package com.mhd.filmkitapligi.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mhd.filmkitapligi.model.Film;

public interface FilmService {
		
	List<Film> getAllFilmler();
	void saveFilm(Film film);
	Film getFilmById(long id);
	void deleteFilmById(long id);
	Page<Film> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
