package com.craftsoft.edu.rest;

import org.springframework.http.MediaType;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.craftsoft.edu.model.request.ReservationRequest;
import com.craftsoft.edu.model.response.ReservationResponse;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	
	
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> getAvilableRooms(
			@RequestParam(value = "checkin")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkin,
			@RequestParam(value = "checkin")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkout){
		
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> createReservation (
			@RequestBody
			ReservationRequest reservationRequest){
		return new ResponseEntity<> (new ReservationResponse(), HttpStatus.CREATED);
	}
}
