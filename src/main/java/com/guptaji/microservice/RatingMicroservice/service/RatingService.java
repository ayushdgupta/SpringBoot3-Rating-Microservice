package com.guptaji.microservice.RatingMicroservice.service;

import com.guptaji.microservice.RatingMicroservice.entity.Rating;

import java.util.List;

public interface RatingService {

  Rating createRating(Rating rating);

  List<Rating> getAllRatings();

  Rating getRatingById(int id);

  List<Rating> getAllRatingsByUserId(int id);

  List<Rating> getAllRatingsByHotelId(int id);
}
