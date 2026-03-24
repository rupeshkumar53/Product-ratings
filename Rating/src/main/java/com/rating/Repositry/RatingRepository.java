package com.rating.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.Model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByProductName(String productName);
    List<Rating> findByClientName(String clientName);
}