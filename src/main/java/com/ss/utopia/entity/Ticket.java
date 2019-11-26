package com.ss.utopia.entity;

import java.io.Serializable;
import java.util.Collection;

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
	
	@Column(name = "cost")
	private float cost;
	
	@OneToMany(mappedBy = "booking")
	private Collection<Booking> bookings;
	
	public Ticket(Integer ticketId, Flight flight, float cost, Collection<Booking> bookings) {
		super();
		this.ticketId = ticketId;
		this.flight = flight;
		this.cost = cost;
		this.bookings = bookings;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((ticketId == null) ? 0 : ticketId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (ticketId == null) {
			if (other.ticketId != null)
				return false;
		} else if (!ticketId.equals(other.ticketId))
			return false;
		return true;
	}
	
	
}
