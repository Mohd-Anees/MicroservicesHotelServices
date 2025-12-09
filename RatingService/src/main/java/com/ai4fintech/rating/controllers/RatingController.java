package com.ai4fintech.rating.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ai4fintech.rating.entities.Rating;
import com.ai4fintech.rating.services.RatingService;

@RestController
@RequestMapping("/ratings") 
public class RatingController {

    @Autowired
    private RatingService ratingService;
    


    // ✅ Create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    // ✅ Get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ok(ratingService.getRating());
    }

    // ✅ Get ratings by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(ratingService.getRatingByUser(userId));
    }


    // ✅ Get ratings by hotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    // ✅ Update rating by id
    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable String id, @RequestBody Rating rating) {
        Rating updatedRating = ratingService.updateRating(rating, id);
        return ResponseEntity.ok(updatedRating);
    }

    // ✅ Optional: Delete rating by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
