package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectorsFilter implements Filter {

    String directors;

    @Autowired
    MovieRepository movieRepository;

    public DirectorsFilter(String directors) {
        this.directors = directors;
    }

    @Override
    public boolean satisfies(Long id) {
        String[] directorsSplit = directors.split(",");
        Movie movie = movieRepository.getById(id);
        for (String s : directorsSplit) {
            if (movie.getDirector().contains(s)) {
                return true;
            }
        }
        return false;
    }
}
