package com.ss.utopia.service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.utopia.dao.AirportDataAccess;
import com.ss.utopia.dao.BookingDataAccess;
import com.ss.utopia.dao.FlightDataAccess;
import com.ss.utopia.dao.FlightPathDataAccess;
import com.ss.utopia.dao.TicketDataAccess;
import com.ss.utopia.dao.UserDataAccess;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightPath;
import com.ss.utopia.entity.Ticket;

@Component
public class UtopiaService {

	@Autowired
	AirportDataAccess airportDao;

	@Autowired
	BookingDataAccess bookingDao;
	
	@Autowired
	FlightDataAccess flightDao;
	
	@Autowired
	FlightPathDataAccess flightPathDao;
	
	@Autowired
	TicketDataAccess ticketDao;
	
	@Autowired
	UserDataAccess userDao;

	public Optional<Airport> readAirportById(String airportCode){
		System.out.println("\n\nReading airport: " + airportCode + "  -  " + airportDao.findById(airportCode));
		return airportDao.findById(airportCode);
	}
	
	public Iterable<Airport> readAllAirports(){
		return airportDao.findAll();
	}

	public Optional<FlightPath> readFlightPathById(Integer flightPathId){
		return flightPathDao.findById(flightPathId);
	}
	
	public Optional<Booking> readBookingById(Integer bookingId){
		return bookingDao.findById(bookingId);
	}
	
	public Optional<Flight> readFlightById(Integer flightId){
		return flightDao.findById(flightId);
	}
	
	public Optional<Ticket> readTicketById(Integer ticketId){
		return ticketDao.findById(ticketId);
	}
	
	public Optional<Ticket> createTicket(Ticket ticket){
		ticket = ticketDao.save(ticket);
		return ticketDao.findById(ticket.getTicketId());
	}
	
	public Optional<Airport> createAirport(Airport airport){
		airport = airportDao.save(airport);
		System.out.println("\n\nCreating airport: " + airport.toString());
		return airportDao.findById(airport.getAirportCode());
	}
	
	public Iterable<Ticket> readTicketsByBookingId(Integer bookingId){
		return bookingDao.findById(bookingId).get().getTickets();
	}
	
}
