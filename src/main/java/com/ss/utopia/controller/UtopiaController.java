package com.ss.utopia.controller;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.entity.*;
import com.ss.utopia.service.UtopiaService;


@RestController
@RequestMapping(path = "/utopia")
@CrossOrigin
public class UtopiaController {
	@Autowired
	UtopiaService utopiaService;
	
	@GetMapping(path = "/",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> status() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/health",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> healthy() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Reading a single booking by its id
	@GetMapping(path = "/booking/{bookingId}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Booking> readBookingById(@PathVariable Integer bookingId, @RequestHeader MultiValueMap<String, String> header) {
		Optional<Booking> booking = utopiaService.readBookingById(bookingId);
		if (!booking.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Booking>(booking.get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/booking/{bookingId}/isPaid",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Integer> readBookingIsPaidById(@PathVariable Integer bookingCode, @RequestHeader MultiValueMap<String, String> header) {
		Optional<Booking> booking = utopiaService.readBookingById(bookingCode);
		if (!booking.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(booking.get().getIsPaid(), HttpStatus.OK);
	}
	
	// Reading a single airport by its id
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
	public ResponseEntity<FlightPath> readFlightPathById(@PathVariable Integer flightPathId, @RequestHeader MultiValueMap<String, String> header) {
		Optional<FlightPath> flightPath = utopiaService.readFlightPathById(flightPathId);
		if (!flightPath.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FlightPath>(flightPath.get(), HttpStatus.OK);
	}


	@GetMapping(path = "/ticket/{ticketId}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Ticket> readTicketById(@PathVariable Integer ticketId, @RequestHeader MultiValueMap<String, String> header) {
		Optional<Ticket> ticket = utopiaService.readTicketById(ticketId);
		if (!ticket.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ticket>(ticket.get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/tickets/{bookingId}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Iterable<Ticket>> readTicketByBookingId(@PathVariable Integer bookingId, @RequestHeader MultiValueMap<String, String> header) {
		Iterable<Ticket> tickets = utopiaService.readTicketsByBookingId(bookingId);
		if (!tickets.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Iterable<Ticket>>(tickets, HttpStatus.OK);
	}
	
	@PostMapping(value = "/ticket",consumes = {"application/xml", "application/json"},
										produces = {"application/xml", "application/json"})
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		
		System.out.println("----------------------");
		System.out.println(ticket.toString());		
		
		if (!utopiaService.readFlightById(ticket.getFlight().getFlightId()).isPresent()
				|| !utopiaService.readBookingById(ticket.getBooking().getBookingId()).isPresent()) {
			return new ResponseEntity<Ticket>(HttpStatus.BAD_REQUEST);
		}
		utopiaService.createTicket(ticket);

		ticket.setFlight(utopiaService.readFlightById(ticket.getFlight().getFlightId()).get());
		ticket.setBooking(utopiaService.readBookingById(ticket.getBooking().getBookingId()).get());
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
		// Code 201
	}
	
	@GetMapping(path = "/booking/user/{userId}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Iterable<Booking>> readBookingsByUserId(@PathVariable Integer userId, @RequestHeader MultiValueMap<String, String> header) {
		Iterable<Booking> bookings = utopiaService.readBookingsByUserId(userId);
		if (!bookings.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Iterable<Booking>>(bookings, HttpStatus.OK);
	}

	@GetMapping(path = "/tickets/user/{userId}",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Iterable<Ticket>> readTicketsByUserId(@PathVariable Integer userId, @RequestHeader MultiValueMap<String, String> header) {
		Iterable<Ticket> tickets = utopiaService.readTicketsByUserId(userId);
		if (!tickets.iterator().hasNext()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Iterable<Ticket>>(tickets, HttpStatus.OK);
	}
	
	@PutMapping(path = "booking/paid",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Booking> updateBookingIsPaid(@RequestHeader(value ="bookingID") Integer bookingId) {
		if(bookingId == null || utopiaService.readBookingById(bookingId).get().getIsPaid() == 1){
			return new ResponseEntity<Booking>(new Booking(),HttpStatus.BAD_REQUEST);
		}
		if(!utopiaService.readBookingById(bookingId).isPresent()) {
			return new ResponseEntity<Booking>(new Booking(),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Booking>(utopiaService.updateBookingIsPaid(bookingId),HttpStatus.OK);
	}
	
}
