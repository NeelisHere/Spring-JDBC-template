package com.web;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.web.model.EmpModel;
import com.web.model.Movie;
import com.web.model.Rating;
import com.web.service.EmpService;
import com.web.service.MovieService;
import com.web.service.RatingService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		
		//-----------------------------------------------
		
		Movie m = context.getBean(Movie.class);
		m.setMovieId(1);
		m.setTitle("Hera Pheri");
		m.setGenre("Comedy");
		
		MovieService movieService = context.getBean(MovieService.class);
//		movieService.addMovieService(m);
//		movieService.deleteMovieService(4);
//		movieService.updateMovieGenreService(m);
//		movieService.updateMovieTitleService(m);
		
		List<Movie> result = movieService.getMovieService();
		for(Movie x: result) {	
			System.out.println(x.toString());
		}
		
		//-------------------------------------
		
//		Rating r = context.getBean(Rating.class);
//		r.setUserId(106);
//		r.setMovieId(5);;
//		r.setRating(4);
//		r.setTime_stamp("19-SEP-2022");
		
//		RatingService ratingService = context.getBean(RatingService.class);
//		ratingService.addRatingService(r);
//		ratingService.deleteRatingService(106);
		
//		List<Rating> result1 = ratingService.getRatingsService();
//		for(Rating x: result1) {	
//			System.out.println(x.toString());
//		}
		
//		r.setRating(8);
//		ratingService.updateRatingService(r);
//		
//		List<Rating> result2 = ratingService.getRatingsService();
//		for(Rating x: result2) {	
//			System.out.println(x.toString());
//		}
	}

}
