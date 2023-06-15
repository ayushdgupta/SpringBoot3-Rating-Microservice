package com.guptaji.microservice.RatingMicroservice.repositories;

import com.guptaji.microservice.RatingMicroservice.entity.Rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {

  List<Rating> findByUserId(int userId);

  List<Rating> findByHotelId(int userId);
}
