package com.jerry.recommendation_system.repository;

import com.jerry.recommendation_system.model.Rater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaterRepository extends JpaRepository<Rater, Long> {
    Optional<Rater> findByUsername(String username);
}
