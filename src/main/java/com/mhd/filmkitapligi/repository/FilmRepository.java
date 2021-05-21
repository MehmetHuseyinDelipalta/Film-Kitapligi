package com.mhd.filmkitapligi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhd.filmkitapligi.model.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

}
