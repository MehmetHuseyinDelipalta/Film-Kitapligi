package com.mhd.filmkitapligi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mhd.filmkitapligi.model.Film;
import com.mhd.filmkitapligi.repository.FilmRepository;


@Service
public class FilmServiceImpl implements FilmService{

	
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Override 
	public List<Film> getAllFilmler() {
	
		return filmRepository.findAll();
	}
	
	@Override
	public void saveFilm(Film film) {
		this.filmRepository.save(film);
	}
	
	
	@Override
	public Film getFilmById(long id) {
		Optional<Film> optional = filmRepository.findById(id);
		Film film = null;
		if (optional.isPresent()) {
			film = optional.get();
		} else {
			throw new RuntimeException(" Film not found for id :: " + id);
		}
		return film;
	}
	
	

	@Override
	public void deleteFilmById(long id) {
		this.filmRepository.deleteById(id);
	}

	@Override
	public Page<Film> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.filmRepository.findAll(pageable);
	}

}
