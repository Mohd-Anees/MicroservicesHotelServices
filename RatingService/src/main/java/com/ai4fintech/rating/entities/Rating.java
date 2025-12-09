package com.ai4fintech.rating.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_ratings")  // ✅ This is correct
public class Rating {

	@Id
	@Field("_id")  // ✅ Map ratingId to MongoDB's _id field
	private String ratingId;
	
	@Field("userId")  // ✅ Explicitly map to userId
	private String userId;
	
	@Field("hotelId")  // ✅ Explicitly map to hotelId
	private String hotelId;
	
	@Field("rating")  // ✅ Explicitly map to rating
	private int rating;
	
	@Field("feedback")  // ✅ Explicitly map to feedback
	private String feedback;

	public Rating() {
		super();
	}

	public Rating(String ratingId, String userId, String hotelId, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
	}

	// Getters and Setters remain the same
	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", rating=" + rating
				+ ", feedback=" + feedback + "]";
	}
}