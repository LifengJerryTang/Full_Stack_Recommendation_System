package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MinutesFilter implements Filter {

    private int minMinutes;
    private int maxMinutes;

    @Autowired
    private MovieRepository movieRepository;

    public MinutesFilter(int minMinutes, int maxMinutes) {
        this.minMinutes = minMinutes;
        this.maxMinutes = maxMinutes;
    }

    @Override
    public boolean satisfies(Long id) {
        Movie movie = movieRepository.getById(id);
        int movieMinutes = movie.getMinutes();

        return movieMinutes >= minMinutes && movieMinutes <= maxMinutes;
    }
}
