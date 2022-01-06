package com.jerry.recommendation_system.security;

import com.jerry.recommendation_system.model.Rater;
import com.jerry.recommendation_system.repository.RaterRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class RaterDetailsServiceImpl implements UserDetailsService {

    private RaterRepository raterRepository;

    public RaterDetailsServiceImpl(RaterRepository applicationUserRepository) {
        this.raterRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Rater> optionalRater = raterRepository.findByUsername(username);
        if (!optionalRater.isPresent()) {
            throw new UsernameNotFoundException(username);
        }

        Rater rater = optionalRater.get();

        return new org.springframework.security.core.userdetails.User(rater.getUsername(),
                rater.getPassword(), emptyList());
    }
}
