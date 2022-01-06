package com.jerry.recommendation_system.service;

import com.jerry.recommendation_system.exception.MovieNotFoundException;
import com.jerry.recommendation_system.exception.RatingNotFoundException;
import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.model.Rater;
import com.jerry.recommendation_system.model.Rating;
import com.jerry.recommendation_system.repository.MovieRepository;
import com.jerry.recommendation_system.repository.RaterRepository;
import com.jerry.recommendation_system.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    RaterRepository raterRepository;

    public Rating findRatingById(Long id) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);

        if(!optionalRating.isPresent()) {
            throw new RatingNotFoundException("Rating with id of " + id + " does not exists!");
        }
        return optionalRating.get();
    }

    public List<Rating> findRatingsByMovieId(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (!optionalMovie.isPresent()) {
            throw new MovieNotFoundException("Movie with id of " + id + " does not exists!");
        }
        return optionalMovie.get().getRatings();
    }

    public List<Rating> findRatingsByRaterId(Long id) {
        Optional<Rater> optionalRater = raterRepository.findById(id);

        if (!optionalRater.isPresent()) {
            throw new MovieNotFoundException("Rater with id of " + id + " does not exists!");
        }
        return optionalRater.get().getMyRatings();
    }

    public Rating saveRating(Rating rating, Long raterId, Long movieId) {
        Movie movie = movieRepository.getById(movieId);
        Optional<Rater> optionalRater = raterRepository.findById(raterId);

        if (!optionalRater.isPresent()) {
            throw new MovieNotFoundException("Rater with id of " + raterId + " does not exists!");
        }

        Rater rater = optionalRater.get();

        movie.addRating(rating);
        rater.addRating(rating);

        rating.setRater(rater);
        rating.setMovieItem(movie);

        movieRepository.save(movie);
        raterRepository.save(rater);

        return ratingRepository.save(rating);

    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
