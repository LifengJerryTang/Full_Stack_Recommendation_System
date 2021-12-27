package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreFilter implements Filter {

    private String genre;
    @Autowired
    MovieRepository movieRepository;

    public GenreFilter(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean satisfies(Long id) {
        Movie movie = movieRepository.getById(id);
        return movie.getGenres().contains(this.genre);
    }
}
