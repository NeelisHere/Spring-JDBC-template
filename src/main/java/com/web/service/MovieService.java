package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Movie;
import com.web.model.Rating;
import com.web.repository.MovieRepo;

@Service
public class MovieService {
	
	@Autowired
	MovieRepo repo;
	
	public void addMovieService(Movie m) {
		System.out.println("add-movie-Service...");
		repo.addMovie(m);
	}
	
	public void updateMovieTitleService(Movie m) {
		System.out.println("updating movie title...");
		repo.updateMovieTitle(m);
	}
	
	public void updateMovieGenreService(Movie m) {
		System.out.println("updating movie genre...");
		repo.updateMovieGenre(m);
	}
	
	public void deleteMovieService(int movieId) {
		System.out.println("deleting record...");
		repo.deleteMovie(movieId);
	}
	
	public List<Movie> getMovieService() {
		System.out.println("get-movies-Service...");
		return repo.getMovies();
	}
}
