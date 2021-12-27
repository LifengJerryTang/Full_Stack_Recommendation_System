package com.jerry.recommendation_system.service;

import com.jerry.recommendation_system.model.Rater;
import com.jerry.recommendation_system.repository.RaterRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RaterService {

    private RaterRepository raterRepository;

    public Rater findRaterById(Long id) {
        return raterRepository.findById(id).get();
    }

    public Rater findRaterByUsername(String username) {
        return raterRepository.findByUsername(username);
    }


}
