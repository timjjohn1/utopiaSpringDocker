package com.ss.utopia.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "booking", schema = "utopia")
public class Booking implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -323939295581875645L;

	@EmbeddedId
    private BookingCompositeKey bookCopyKey;
	
	@Column(name = "airportCode")
	private String airportCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip")
	private Integer zip;
	
	@OneToMany(mappedBy = "user")
	private Collection<User> users;

	public Booking(BookingCompositeKey bookCopyKey, String airportCode, String city, Integer zip,
			Collection<User> users) {
		super();
		this.bookCopyKey = bookCopyKey;
		this.airportCode = airportCode;
		this.city = city;
		this.zip = zip;
		this.users = users;
	}

	/**
	 * @return the bookCopyKey
	 */
	public BookingCompositeKey getBookCopyKey() {
		return bookCopyKey;
	}

	/**
	 * @param bookCopyKey the bookCopyKey to set
	 */
	public void setBookCopyKey(BookingCompositeKey bookCopyKey) {
		this.bookCopyKey = bookCopyKey;
	}

	/**
	 * @return the airportCode
	 */
	public String getAirportCode() {
		return airportCode;
	}

	/**
	 * @param airportCode the airportCode to set
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public Integer getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(Integer zip) {
		this.zip = zip;
	}

	/**
	 * @return the users
	 */
	public Collection<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportCode == null) ? 0 : airportCode.hashCode());
		result = prime * result + ((bookCopyKey == null) ? 0 : bookCopyKey.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		if (airportCode == null) {
			if (other.airportCode != null)
				return false;
		} else if (!airportCode.equals(other.airportCode))
			return false;
		if (bookCopyKey == null) {
			if (other.bookCopyKey != null)
				return false;
		} else if (!bookCopyKey.equals(other.bookCopyKey))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	
	
	
}
