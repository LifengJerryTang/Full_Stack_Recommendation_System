package com.jerry.recommendation_system.repository;

import com.jerry.recommendation_system.model.Rater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaterRepository extends JpaRepository<Rater, Long> {
    Rater findByUsername(String username);
}
