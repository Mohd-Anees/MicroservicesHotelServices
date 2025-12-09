package com.lcwd.hotel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HoterService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HoterService hotelService;
	
	
	
	//create hotel
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
		
	}
	
	//get single hotel
	@GetMapping("/{HotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable("HotelId") String id){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(id));
		
	}
	
	//get All hotel
	
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
		
	}
	
	//delete hotel

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable("id") String id) {
	    hotelService.deleteHotel(id);
	    return ResponseEntity.ok("Hotel deleted successfully with ID: " + id);
	}
	
	
	//update hotel
	@PutMapping("/{hotelId}")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel,@PathVariable("hotelId") String id){
		Hotel updateHotel = hotelService.updateHotel(hotel,id);
		return ResponseEntity.status(HttpStatus.OK).body(updateHotel);
		
	}

}
