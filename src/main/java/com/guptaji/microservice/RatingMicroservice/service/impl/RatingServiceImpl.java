package com.guptaji.microservice.RatingMicroservice.service.impl;

import com.guptaji.microservice.RatingMicroservice.entity.Rating;
import com.guptaji.microservice.RatingMicroservice.repositories.RatingRepo;
import com.guptaji.microservice.RatingMicroservice.service.RatingService;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

  Logger LOG = LogManager.getLogger(RatingServiceImpl.class);

  @Autowired private RatingRepo ratingRepo;

  @Override
  public Rating createRating(Rating rating) {
    LOG.info("Hit createRating service");
    Rating savedRating = ratingRepo.save(rating);
    return savedRating;
  }

  @Override
  public List<Rating> getAllRatings() {
    LOG.info("Hit getAllRatings service");
    List<Rating> ratingList = ratingRepo.findAll();
    return ratingList;
  }

  @Override
  public Rating getRatingById(int id) {
    LOG.info("Hit getRatingById service");
    Rating rating =
        ratingRepo
            .findById(id)
            .orElseThrow(
                () -> new NoSuchElementException("No rating present in DB for the id " + id));
    return rating;
  }

  @Override
  public List<Rating> getAllRatingsByUserId(int id) {
    LOG.info("Hit getAllRatingsByUserId service");
    List<Rating> ratings = ratingRepo.findByUserId(id);
    return ratings;
  }

  @Override
  public List<Rating> getAllRatingsByHotelId(int id) {
    LOG.info("Hit getAllRatingsByHotelId service");
    List<Rating> ratings = ratingRepo.findByHotelId(id);
    return ratings;
  }
}
