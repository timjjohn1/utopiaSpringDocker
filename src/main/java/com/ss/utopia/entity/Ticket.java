package com.ss.utopia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "ticket", schema = "utopia")
public class Ticket implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8597779966652874358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticketId", insertable=false, updatable = false, unique = true, nullable = false)
	private Integer ticketId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flightId", nullable = false)
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookingId", nullable = false)
	private Booking booking;
	
	@Column(name = "cost")
	private float cost;

	public Ticket(Integer ticketId, Flight flight, Booking booking, float cost) {
		super();
		this.ticketId = ticketId;
		this.flight = flight;
		this.booking = booking;
		this.cost = cost;
	}

	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
