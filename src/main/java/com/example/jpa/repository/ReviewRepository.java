package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
