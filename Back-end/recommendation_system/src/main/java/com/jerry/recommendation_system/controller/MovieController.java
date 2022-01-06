package com.jerry.recommendation_system.controller;

import com.jerry.recommendation_system.DTO.MovieDTO;
import com.jerry.recommendation_system.filters.DirectorsFilter;
import com.jerry.recommendation_system.filters.GenreFilter;
import com.jerry.recommendation_system.filters.YearAfterFilter;
import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return convertMovieToMovieDTO(movieService.findMovieById(id));
    }

    @GetMapping("/{title}")
    public MovieDTO getMovieByTitle(@PathVariable String title) {
        return convertMovieToMovieDTO(movieService.findMovieByTitle(title));
    }

    @GetMapping("/{year}")
    public List<MovieDTO> getMoviesByYearAfter(@PathVariable int year) {
        return movieService.findMoviesByCategory(new YearAfterFilter(year))
                .stream().map(this::convertMovieToMovieDTO).collect(Collectors.toList());
    }

    @GetMapping("/{genres}")
    public List<MovieDTO> getMoviesByGenres(@PathVariable String genres) {
        return movieService.findMoviesByCategory(new GenreFilter(genres))
                .stream().map(this::convertMovieToMovieDTO).collect(Collectors.toList());
    }

    @GetMapping("/directors")
    public List<MovieDTO> getMoviesByDirector(@PathVariable List<String> directors) {
        return movieService.findMoviesByCategory(new DirectorsFilter(directors))
                .stream().map(this::convertMovieToMovieDTO).collect(Collectors.toList());
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.findAllMovies().stream().map(this::convertMovieToMovieDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/delete")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @PostMapping
    public MovieDTO saveMovie(@RequestBody MovieDTO movieDTO) {
        Movie newMovie = convertMovieDTOToMovie(movieDTO);
        movieService.saveMovie(newMovie);

        return convertMovieToMovieDTO(newMovie);
    }



    public MovieDTO convertMovieToMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        BeanUtils.copyProperties(movie, movieDTO);

        return movieDTO;
    }

    public Movie convertMovieDTOToMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDTO, movie);

        return movie;
    }

}
