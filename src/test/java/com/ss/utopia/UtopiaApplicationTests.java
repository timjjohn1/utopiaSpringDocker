package com.ss.utopia;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Time;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
import com.ss.utopia.entity.User;
import com.ss.utopia.service.UtopiaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration
@TestPropertySource(locations="classpath:application-default.properties")
public class UtopiaApplicationTests {
	
	@Resource
	AirportDataAccess airportTestDao;
	
	@Resource
	BookingDataAccess bookingTestDao;
	
	@Resource
	FlightDataAccess flightTestDao;
	
	@Resource
	FlightPathDataAccess flightPathTestDao;
	
	@Resource
	TicketDataAccess ticketTestDao;
	
	@Resource
	UserDataAccess userTestDao;
	
	@Autowired
	UtopiaService utopiaService = new UtopiaService();
	
	
	@BeforeAll
    public static void before() {

    }
    
    @Test
    public void insert() {
    	System.out.println("\n\n\n\nTesting...");
    	assertEquals(1,1);
    }
    
    @Test
    public void airports() {
    	Airport airport = new Airport("BWI", "BWI", "Baltimore", 21015);
    	utopiaService.createAirport(airport).get().toString();
//    	utopiaService.readAllAirports().forEach((airportO) -> System.out.println("\n\n\nAirport:" + airportO));
    	int test = 0;
    	if(utopiaService.readAirportById("BWI").isPresent()) {
    		test = 1;
    	}
    	assertEquals(test, 1);
    }
    
    @Test
    public void flight() {
    	int test = 0;
    	Airport srcAirport = new Airport("BWI", "BWI", "Baltimore", 21015);
    	Airport destAirport = new Airport("JFK", "JFK", "New York", 23424);
    	FlightPath flightPath = new FlightPath(1, srcAirport, destAirport);
    	Flight flight = new Flight(1, "747", new Time(455415454l), new Time(123456789l), 55,
    			flightPath);

    	System.out.println(flightTestDao.findAll().spliterator().estimateSize());
    	System.out.println(airportTestDao.save(srcAirport));
    	System.out.println(airportTestDao.save(destAirport));
    	System.out.println(flightPathTestDao.save(flightPath));
    	System.out.println(flightTestDao.save(flight));
    	System.out.println(flightTestDao.findAll().spliterator().estimateSize());
    	if(utopiaService.readFlightById(1).isPresent()) {
    		test = 1;
    	}
    	System.out.println("Hello: " + test);
    	assertEquals(test, 1);
    }
    
//    @Test
//    public void booking() {
//    	int test = 0;
//    	User user = new User(1, "Tim", "Johnson" , "2342 Street" , "42242442342", "timjohnun@email.com");
//    	Booking booking = new Booking(1, user, 0, new Timestamp(32425252124l));
//    	
//    	userTestDao.save(user);
//    	bookingTestDao.save(booking);
//    	
//    	if(utopiaService.readTicketsByBookingId(booking.getBookingId()).iterator().hasNext()) {
//    		test = 1;
//    	}
//    }
}
