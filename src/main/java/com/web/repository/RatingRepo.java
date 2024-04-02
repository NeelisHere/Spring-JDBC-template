package com.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.web.model.Rating;

@Repository
public class RatingRepo {
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public void addRating(Rating r) {
		String sql = "insert into ratings values(?,?,?,?);";
		int data = jdbc.update(sql, r.getUserId(), r.getMovieId(), r.getRating(), r.getTime_stamp());
		System.out.printf("%d reocrds inserted!\n", data);
	}
	
	public void updateRating(Rating r) {
		String sql = "update ratings set rating=? where userId=?;";
		int data = jdbc.update(sql, r.getRating(), r.getUserId());
		System.out.printf("%d reocrds updated!\n", data);
	}
	
	public void deleteRating(int userId) {
		String sql = "delete from ratings where userId=?;";
		int data = jdbc.update(sql, userId);
		System.out.printf("%d reocrds updated!\n", data);
	}
	
	public List<Rating> getRatings() {
		String sql = "select * from ratings;";
		RowMapper<Rating> mapper = new RowMapper<Rating>() {
			@Override
			public Rating mapRow(ResultSet rs, int rowNum) throws SQLException {
				Rating r = new Rating();
				r.setUserId(rs.getInt("userId"));
				r.setMovieId(rs.getInt("movieId"));
				r.setRating(rs.getInt("rating"));
				r.setTime_stamp(rs.getString("time_Stamp"));
				return r;
			}
		};
		return jdbc.query(sql, mapper);
	}
}
