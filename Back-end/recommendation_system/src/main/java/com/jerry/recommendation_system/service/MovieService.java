package com.jerry.recommendation_system.service;


import com.jerry.recommendation_system.exception.MovieNotFoundException;
import com.jerry.recommendation_system.filters.Filter;
import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie findMovieById(Long id) {

        Optional<Movie> optionalMovie = Optional.of(movieRepository.getById(id));

        if (!optionalMovie.isPresent()) {
            throw new MovieNotFoundException("Movie with id of " + id + " does not exists!");
        }

        return optionalMovie.get();
    }

    public Movie findMovieByTitle(String title) {

        Optional<Movie> optionalMovie = movieRepository.findByTitle(title);

        if (!optionalMovie.isPresent()) {
            throw new MovieNotFoundException("Movie named " + title + " does not exists!");
        }

        return optionalMovie.get();
    }

    public List<Movie> findMoviesByCategory(Filter filter) {
        return movieRepository.findAll().stream().filter(movie -> filter.satisfies(movie.getId()))
                .collect(Collectors.toList());
    }

    public List<Movie> findMoviesByCountry(String country) {
        return movieRepository.findAll().stream().filter(movie -> movie.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
