package com.lcwd.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.services.HoterService;

@Service
public class HotelServiceImpl implements HoterService{
    @Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
	
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
	
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel with given id is not found:"+hotelId));
	}

	
	@Override
	public void deleteHotel(String id) {
	    Hotel hotel = hotelRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found: " + id));
	    
	    hotelRepository.delete(hotel);
	}


	@Override
	public Hotel updateHotel(Hotel hotel, String id) {
		Hotel updateHotel = hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found for particuler id::"+id));
		return updateHotel;
	}

}
