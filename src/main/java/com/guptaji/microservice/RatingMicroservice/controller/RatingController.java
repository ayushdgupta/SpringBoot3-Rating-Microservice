package com.guptaji.microservice.RatingMicroservice.controller;

import com.guptaji.microservice.RatingMicroservice.entity.Rating;
import com.guptaji.microservice.RatingMicroservice.service.impl.RatingServiceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

  Logger LOG = LogManager.getLogger(RatingController.class);

  @Autowired private RatingServiceImpl ratingService;

  @PostMapping
  public ResponseEntity<?> insertNewRating(@RequestBody Rating rating) {
    LOG.info("Hit insertNewRating API");
    Rating savedRating = ratingService.createRating(rating);
    return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<?> fetchAllRatings() {
    LOG.info("Hit fetchAllRatings API");
    List<Rating> ratings = ratingService.getAllRatings();
    return new ResponseEntity<>(ratings, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> fetchRatingById(@PathVariable("id") int id) {
    LOG.info("Hit fetchRatingById API");
    Rating rating = ratingService.getRatingById(id);
    return new ResponseEntity<>(rating, HttpStatus.FOUND);
  }

  @GetMapping("/ratingByUserId/{userId}")
  public ResponseEntity<?> fetchRatingsByUserId(@PathVariable("userId") int userId) {
    LOG.info("Hit fetchRatingsByUserId API");
    List<Rating> ratings = ratingService.getAllRatingsByUserId(userId);
    return new ResponseEntity<>(ratings, HttpStatus.OK);
  }

  @GetMapping("/ratingByHotelId/{hotelId}")
  public ResponseEntity<?> fetchRatingsByHotelId(@PathVariable("hotelId") int hotelId) {
    LOG.info("Hit fetchRatingsByHotelId API");
    List<Rating> ratings = ratingService.getAllRatingsByHotelId(hotelId);
    return new ResponseEntity<>(ratings, HttpStatus.OK);
  }
}
