package com.ai4fintech.rating.services;

import java.util.List;

import com.ai4fintech.rating.entities.Rating;

public interface RatingService {
	
	//create rating
	public Rating create(Rating rating);
	
	//get all ratings
	public List<Rating> getRating();
	
	//get all by userId
	public List<Rating> getRatingByUser(String id);
	
	
	//get all by hotelId
	List<Rating> getRatingByHotelId(String hotelId);
	
	//delete rating by id
	public Rating deleteRating(String id);
	
	//update rating
	public Rating updateRating(Rating rating,String id);
	

}
