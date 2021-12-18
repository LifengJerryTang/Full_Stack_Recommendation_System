package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;

public class GenreFilter implements Filter {

    private String genre;
    private MovieRepository repository;

    public GenreFilter(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean satisfies(Long id) {
        Movie movie = repository.getById(id);
        return movie.getGenres().contains(this.genre);
    }
}
