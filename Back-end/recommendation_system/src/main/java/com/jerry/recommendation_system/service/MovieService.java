package com.jerry.recommendation_system.service;


import com.jerry.recommendation_system.filters.Filter;
import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie findMovieById(Long id) {
        return movieRepository.getById(id);
    }

    public Movie findMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> findMovieByCategory(Filter filter, Long id) {
        return movieRepository.findAll().stream().filter(movie -> filter.satisfies(id))
                .collect(Collectors.toList());
    }

    public List<Movie> findMovieByCountry(String country) {
        return movieRepository.findAll().stream().filter(movie -> movie.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
