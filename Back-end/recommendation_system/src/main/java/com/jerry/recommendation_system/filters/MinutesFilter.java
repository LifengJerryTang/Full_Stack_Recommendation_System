package com.jerry.recommendation_system.filters;

import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.repository.MovieRepository;

public class MinutesFilter implements Filter {

    private int minMinutes;
    private int maxMinutes;

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
