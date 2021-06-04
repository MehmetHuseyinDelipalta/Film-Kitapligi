package com.mhd.filmkitapligi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filmler")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "film_adi")
	private String filmAdi;

	@Column(name = "film_yayin_yili")
	private String filmYayinYili;

	@Column(name = "film_turu")
	private String filmTuru;

	@Column(name = "film_aciklama")
	private String filmAciklama;

	@Column(name = "film_medya")
	private String filmMedya;

	@Column(name = "film_dili")
	private String filmDili;

	@Column(name = "film_oyunculari")
	private String filmOyunculari;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilmAdi() {
		return filmAdi;
	}

	public void setFilmAdi(String filmAdi) {
		this.filmAdi = filmAdi;
	}

	public String getFilmYayinYili() {
		return filmYayinYili;
	}

	public void setFilmYayinYili(String filmYayinYili) {
		this.filmYayinYili = filmYayinYili;
	}

	public String getFilmTuru() {
		return filmTuru;
	}

	public void setFilmTuru(String filmTuru) {
		this.filmTuru = filmTuru;
	}

	public String getFilmAciklama() {
		return filmAciklama;
	}

	public void setFilmAciklama(String filmAciklama) {
		this.filmAciklama = filmAciklama;
	}

	public String getFilmMedya() {
		return filmMedya;
	}

	public void setFilmMedya(String filmMedya) {
		this.filmMedya = filmMedya;
	}

	public String getFilmDili() {
		return filmDili;
	}

	public void setFilmDili(String filmDili) {
		this.filmDili = filmDili;
	}

	public String getFilmOyunculari() {
		return filmOyunculari;
	}

	public void setFilmOyunculari(String filmOyunculari) {
		this.filmOyunculari = filmOyunculari;
	}
}
