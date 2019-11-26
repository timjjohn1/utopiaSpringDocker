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

@Component
public class UtopiaService {
//
//	private DataAccess<Book> bookDao = null;
//	private DataAccess<LibraryBranch> libraryBranchDao = null;
//	private DataAccess<BookCopy> bookCopyDao = null;
//	
//	public UserLibrarian(BookDataAccess bookDao, LibraryBranchDataAccess libraryBranchDao, BookCopyDataAccess bookCopyDao) {
//		this.bookDao = bookDao;
//		this.libraryBranchDao = libraryBranchDao;
//		this.bookCopyDao = bookCopyDao;
//	}
//	
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
	
//	public void createBookCopy(BookCopy bookCopy) {
//		bookCopyDao.save(bookCopy);
//	}
//
//	public Iterable<Book> readAllBooks() {
//		return bookDao.findAll();
//	}
//	
//	public Optional<Book> readBookById(Integer bookId) {
//		return bookDao.findById(bookId);
//	}
//
//	
//	public Optional<LibraryBranch> readLibraryBranchById(Integer branchId) {
//		return libraryBranchDao.findById(branchId);
//	}
//
//	public Iterable<LibraryBranch> readAllLibraryBranches() {
//
//		return libraryBranchDao.findAll();
//	}
//	
//	public Iterable<BookCopy> readAllBookCopies() {
//		return bookCopyDao.findAll();
//	}
//	
//	public Optional<BookCopy> readBookCopyById(BookCopyCompositeKey bookCopyId) {
//		return bookCopyDao.findById(bookCopyId);
//	}
//
//	
//	public void updateLibraryBranch(LibraryBranch libraryBranch) {
//		libraryBranchDao.save(libraryBranch);
//
//	}
//
//	
//	public void updateBookCopy(BookCopy bookCopy) {
//		bookCopyDao.save(bookCopy);
//
//	}
//
//	
//	public void deleteBookCopy(BookCopyCompositeKey bookCopyId) {
//		bookCopyDao.deleteById(bookCopyId);
//
//	}

}
