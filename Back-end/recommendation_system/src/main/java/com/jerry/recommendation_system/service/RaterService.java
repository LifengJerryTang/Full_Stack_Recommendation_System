package com.jerry.recommendation_system.service;

import com.jerry.recommendation_system.exception.RaterNotFoundException;
import com.jerry.recommendation_system.model.Rater;
import com.jerry.recommendation_system.repository.RaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RaterService {

    @Autowired
    private RaterRepository raterRepository;

    public List<Rater> findAllRaters() {
        return raterRepository.findAll();
    }

    public Rater findRaterById(Long id) {
        Optional<Rater> optionalRater = raterRepository.findById(id);

        if (!optionalRater.isPresent()) {
            throw new RaterNotFoundException("Rater with the id of " + id + " does not exists!");
        }

        return optionalRater.get();
    }

    public Rater findRaterByUsername(String username) {
        Optional<Rater> optionalRater = raterRepository.findByUsername(username);

        if (!optionalRater.isPresent()) {
            throw new RaterNotFoundException("Rater with the username " + username + " does not exists!");
        }

        return optionalRater.get();
    }

    public Rater saveRater(Rater rater) {
        return raterRepository.save(rater);
    }

    public void deleteRater(Long id) {
        raterRepository.deleteById(id);
    }

}
