package com.jerry.recommendation_system.service;

import com.jerry.recommendation_system.model.Rating;
import com.jerry.recommendation_system.repository.MovieRepository;
import com.jerry.recommendation_system.repository.RaterRepository;
import com.jerry.recommendation_system.repository.RatingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RatingService {

    RatingRepository ratingRepository;

    MovieRepository movieRepository;

    RaterRepository raterRepository;

    public Rating findRatingById(Long id) {
        return ratingRepository.findById(id).get();
    }

    public List<Rating> findRatingsByMovieId(Long id) {
        return movieRepository.findById(id).get().getRatings();
    }

    public List<Rating> findRatingsByRaterId(Long id) {
        return raterRepository.findById(id).get().getMyRatings();
    }



}
