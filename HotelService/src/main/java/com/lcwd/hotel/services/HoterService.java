package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HoterService {
	
	//create hotel
	public Hotel createHotel(Hotel hotel );
	
	//get all the hotel
	public List<Hotel> getAllHotel();
	
	//get single hotel
	public Hotel getHotel(String hotelId);
	
	//delete hotel
	public void deleteHotel(String id);
	

	
	//update hotel
	public Hotel updateHotel(Hotel hotel,String id);

}
