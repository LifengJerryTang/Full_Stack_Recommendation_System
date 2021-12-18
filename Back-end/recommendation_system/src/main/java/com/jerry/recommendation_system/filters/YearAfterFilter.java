package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;

public class YearAfterFilter implements Filter {

	private int myYear;
	private MovieRepository movieRepository;
	
	public YearAfterFilter(int year) {
		myYear = year;
	}
	
	@Override
	public boolean satisfies(Long id) {
		Movie movie = movieRepository.getById(id);
		return movie.getYear() >= myYear;
	}

}
