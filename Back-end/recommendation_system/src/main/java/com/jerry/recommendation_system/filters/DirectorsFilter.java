package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DirectorsFilter implements Filter {

    List<String> directors;

    @Autowired
    MovieRepository movieRepository;

    public DirectorsFilter(List<String> directors) {
        this.directors = directors;
    }

    @Override
    public boolean satisfies(Long id) {
        Movie movie = movieRepository.getById(id);
        for (String s : directors) {
            if (movie.getDirector().contains(s)) {
                return true;
            }
        }
        return false;
    }
}
