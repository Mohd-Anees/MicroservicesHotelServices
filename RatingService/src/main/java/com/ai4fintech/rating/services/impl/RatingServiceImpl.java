package com.ai4fintech.rating.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai4fintech.rating.entities.Rating;
import com.ai4fintech.rating.repository.RatingRepository;
import com.ai4fintech.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
    
	@Autowired
	private RatingRepository ratingRepository;
	
	
	@Override
	public Rating create(Rating rating) {
		String uu = UUID.randomUUID().toString();
		rating.setRatingId(uu);
		return ratingRepository.save(rating);
	}
	

	@Override
	public List<Rating> getRating() {
		return ratingRepository.findAll();
	}




	@Override
	public List<Rating> getRatingByUser(String id) {

		return ratingRepository.findByUserId(id);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return ratingRepository.findByHotelId(hotelId);
	}
	

    @Override
    public Rating updateRating(Rating rating, String id) {
        Rating existing = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found with id: " + id));

        existing.setUserId(rating.getUserId());
        existing.setHotelId(rating.getHotelId());
        existing.setFeedback(rating.getFeedback());
        existing.setRating(rating.getRating());

        return ratingRepository.save(existing);
    }

    @Override
    public Rating deleteRating(String id) {
        Rating existing = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found with id: " + id));

        ratingRepository.delete(existing);
        return existing; 
    }



}
