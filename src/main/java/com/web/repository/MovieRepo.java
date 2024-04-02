package com.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.web.model.Movie;

@Repository
public class MovieRepo {
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public void addMovie(Movie m) {
		String sql = "insert into movies values(?,?,?);";
		int data = jdbc.update(sql, m.getMovieId(), m.getTitle(), m.getGenre());
		System.out.printf("%d reocrds inserted!\n", data);
	}
	
	public void updateMovieTitle(Movie m) {
		String sql = "update movies set title=? where movieId=?;";
		int data = jdbc.update(sql, m.getTitle(), m.getMovieId());
		System.out.printf("%d reocrds updated!\n", data);
	}
	
	public void updateMovieGenre(Movie m) {
		String sql = "update movies set genre=? where movieId=?;";
		int data = jdbc.update(sql, m.getGenre(), m.getMovieId());
		System.out.printf("%d reocrds updated!\n", data);
	}
	
	public void deleteMovie(int movieId) {
		String sql = "delete from movies where movieId=?;";
		int data = jdbc.update(sql, movieId);
		System.out.printf("%d reocrds updated!\n", data);
	}
	
	public List<Movie> getMovies() {
		String sql = "select * from movies;";
		RowMapper<Movie> mapper = new RowMapper<Movie>() {
			@Override
			public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
				Movie m = new Movie();
				m.setMovieId(rs.getInt("movieId"));
				m.setTitle(rs.getString("title"));
				m.setGenre(rs.getString("genre"));
				return m;
			}
		};
		return jdbc.query(sql, mapper);
	}

}
