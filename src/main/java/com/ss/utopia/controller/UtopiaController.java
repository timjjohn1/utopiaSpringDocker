package com.ss.utopia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.entity.*;
import com.ss.utopia.service.UtopiaService;


@RestController
@RequestMapping(path = "/utopia")
public class UtopiaController {
	@Autowired
	UtopiaService utopiaService;
	
	@GetMapping(path = "/",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> readAirportById() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Reading a single book by its id
	@GetMapping(path = "/airport/{airportCode}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Airport> readAirportById(@PathVariable String airportCode, @RequestHeader MultiValueMap<String, String> header) {
		Optional<Airport> airport = utopiaService.readAirportById(airportCode);
		if (!airport.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Airport>(airport.get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/flightPath/{flightPathId}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<FlightPath> readAirportById(@PathVariable Integer flightPathId, @RequestHeader MultiValueMap<String, String> header) {
		Optional<FlightPath> flightPath = utopiaService.readFlightPathById(flightPathId);
		if (!flightPath.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FlightPath>(flightPath.get(), HttpStatus.OK);
	}

	/*
	
	
			User Mappings
	
	
	*/
	
	//ge
}
