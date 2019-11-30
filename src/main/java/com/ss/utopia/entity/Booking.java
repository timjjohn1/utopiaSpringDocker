package com.ss.utopia.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name = "booking", schema = "utopia")
public class Booking implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -323939295581875645L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingId", updatable = false, unique = true, nullable = false)
	private Integer bookingId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	
	@Column(name = "isPaid")
	private Integer isPaid;
	
	@Column(name = "bookDate")
	private Timestamp bookDate;
	
	@OneToMany(mappedBy = "booking")
	private Collection<Ticket> tickets;
	
	public Booking() {}
	
	public Booking(Integer bookingId, User user, Integer isPaid, Timestamp bookDate) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.isPaid = isPaid;
		this.bookDate = bookDate;
	}

	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the isPaid
	 */
	public Integer getIsPaid() {
		return isPaid;
	}

	/**
	 * @param isPaid the isPaid to set
	 */
	public void setIsPaid(Integer isPaid) {
		this.isPaid = isPaid;
	}

	/**
	 * @return the bookDate
	 */
	public Timestamp getBookDate() {
		return bookDate;
	}

	/**
	 * @param bookDate the bookDate to set
	 */
	public void setBookDate(Timestamp bookDate) {
		this.bookDate = bookDate;
	}

	/**
	 * @return the tickets
	 */
	public Collection<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookDate == null) ? 0 : bookDate.hashCode());
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((isPaid == null) ? 0 : isPaid.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Booking other = (Booking) obj;
		if (bookDate == null) {
			if (other.bookDate != null)
				return false;
		} else if (!bookDate.equals(other.bookDate))
			return false;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (isPaid == null) {
			if (other.isPaid != null)
				return false;
		} else if (!isPaid.equals(other.isPaid))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}
