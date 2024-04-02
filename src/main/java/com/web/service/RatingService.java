package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Rating;
import com.web.repository.RatingRepo;

@Service
public class RatingService {
	@Autowired
	RatingRepo repo;
	
	public void addRatingService(Rating r) {
		System.out.println("adding rating...");
		repo.addRating(r);
	}
	
	public void updateRatingService(Rating r) {
		System.out.println("updating record...");
		repo.updateRating(r);
	}
	
	public void deleteRatingService(int userId) {
		System.out.println("deleting record...");
		repo.deleteRating(userId);
	}
	
	public List<Rating> getRatingsService() {
		System.out.println("fetching ratings...");
		return repo.getRatings();
	}
}
