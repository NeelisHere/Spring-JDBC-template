package com.web.model;

import org.springframework.stereotype.Component;

@Component
public class Rating {
	private int userId;
	private int movieId;
	private int rating;
	private String time_stamp;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getTime_stamp() {
		return time_stamp;
	}
	
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	
	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + ", time_stamp=" + time_stamp
				+ "]";
	}
	
}
