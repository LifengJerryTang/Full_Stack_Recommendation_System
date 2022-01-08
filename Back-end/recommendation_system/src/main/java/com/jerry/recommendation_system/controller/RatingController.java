package com.jerry.recommendation_system.controller;

import com.jerry.recommendation_system.DTO.RatingDTO;
import com.jerry.recommendation_system.model.Rating;
import com.jerry.recommendation_system.service.RatingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/{id}")
    public RatingDTO getRatingById(@PathVariable Long id) {
        return convertRatingToRatingDTO(ratingService.findRatingById(id));
    }

    @GetMapping("/movie/{movieId}")
    public List<RatingDTO> findRatingsByMovieId(@PathVariable Long movieId) {
        return ratingService.findRatingsByMovieId(movieId).stream()
                .map(this::convertRatingToRatingDTO).collect(Collectors.toList());
    }


    @GetMapping("/rater/{raterId}")
    public List<RatingDTO> findRatingsByRaterId(@PathVariable Long raterId) {
        return ratingService.findRatingsByRaterId(raterId).stream()
                .map(this::convertRatingToRatingDTO).collect(Collectors.toList());
    }

    @PostMapping
    public RatingDTO saveRating(@RequestBody RatingDTO ratingDTO) {
        String movieName = ratingDTO.getMovieName();
        String raterUsername = ratingDTO.getRaterUsername();

        Rating rating = convertRatingDTOToRating(ratingDTO);

        return convertRatingToRatingDTO(ratingService.saveRating(rating, raterUsername, movieName));
    }

    public RatingDTO convertRatingToRatingDTO(Rating rating) {
        RatingDTO ratingDTO = new RatingDTO();
        BeanUtils.copyProperties(rating, ratingDTO);

        return ratingDTO;
    }

    public Rating convertRatingDTOToRating(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        BeanUtils.copyProperties(ratingDTO, rating);

        return rating;
    }
}
