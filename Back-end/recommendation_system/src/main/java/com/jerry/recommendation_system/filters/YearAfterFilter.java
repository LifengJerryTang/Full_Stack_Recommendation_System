package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YearAfterFilter implements Filter {

	private int myYear;

	@Autowired
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
