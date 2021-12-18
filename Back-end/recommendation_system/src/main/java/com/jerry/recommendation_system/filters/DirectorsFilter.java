package com.jerry.recommendation_system.filters;

import Movie.MovieDatabase;

public class DirectorsFilter implements Filter {
    String directors;

    public DirectorsFilter(String directors) {
        this.directors = directors;
    }

    @Override
    public boolean satisfies(String id) {
        String[] directorsSplit = directors.split(",");
        for (String s : directorsSplit) {
            if (MovieDatabase.getDirector(id).contains(s)) {
                return true;
            }
        }
        return false;
    }
}
