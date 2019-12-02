package com.ss.utopia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ss.utopia.dao.AirportDataAccess;
import com.ss.utopia.dao.BookingDataAccess;
import com.ss.utopia.dao.CardInfoDataAccess;
import com.ss.utopia.dao.FlightDataAccess;
import com.ss.utopia.dao.FlightPathDataAccess;
import com.ss.utopia.dao.TicketDataAccess;
import com.ss.utopia.dao.UserDataAccess;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.FlightPath;

@Component
public class UtopiaService {

	@Autowired
	AirportDataAccess airportDao;

	@Autowired
	BookingDataAccess bookingDao;

	@Autowired
	CardInfoDataAccess cardInfoDao;
	
	@Autowired
	FlightDataAccess flightDao;
	
	@Autowired
	FlightPathDataAccess flightPathDao;
	
	@Autowired
	TicketDataAccess ticketDao;
	
	@Autowired
	UserDataAccess userDao;

	public Optional<Airport> readAirportById(String airportCode){
		return airportDao.findById(airportCode);
	}

	public Optional<FlightPath> readFlightPathById(Integer flightPathId){
		return flightPathDao.findById(flightPathId);
	}
	
	public Optional<Booking> readBookingById(Integer bookingId){
		return bookingDao.findById(bookingId);
	}
}
