package com.ss.utopia.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;

@Entity 
@Table(name = "flight", schema = "utopia")
public class Flight implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5263940821247898053L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flightId", updatable = false, unique = true)
	private Integer flightId;
	
	@Column(name = "plane")
	private String plane;
	
	@Column(name = "arrivalTime")
	private Time arrivalTime;
	
	@Column(name = "departureTime")
	private Time departureTime;
	
	@Column(name = "totalSeats")
	private Integer totalSeats;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flightPathId", nullable = false)
	private FlightPath flightPath;
	
	@OneToMany(mappedBy = "flight")
	@JsonIgnore
	private Collection<Ticket> tickets;

	public Flight() {}
	
	public Flight(Integer flightId, String plane, Time arrivalTime, Time departureTime, Integer totalSeats,
			FlightPath flightPath) {
		super();
		this.flightId = flightId;
		this.plane = plane;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.totalSeats = totalSeats;
		this.flightPath = flightPath;
	}



	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", plane=" + plane + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", totalSeats=" + totalSeats + ", flightPath=" + flightPath + ", tickets=" + "]";
	}



	/**
	 * @return the flightId
	 */
	public Integer getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	/**
	 * @return the plane
	 */
	public String getPlane() {
		return plane;
	}

	/**
	 * @param plane the plane to set
	 */
	public void setPlane(String plane) {
		this.plane = plane;
	}

	/**
	 * @return the arrivalTime
	 */
	public Time getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the departureTime
	 */
	public Time getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the totalSeats
	 */
	public Integer getTotalSeats() {
		return totalSeats;
	}

	/**
	 * @param totalSeats the totalSeats to set
	 */
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	/**
	 * @return the flightPath
	 */
	public FlightPath getFlightPath() {
		return flightPath;
	}

	/**
	 * @param flightPath the flightPath to set
	 */
	public void setFlightPath(FlightPath flightPath) {
		this.flightPath = flightPath;
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
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((flightPath == null) ? 0 : flightPath.hashCode());
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		result = prime * result + ((totalSeats == null) ? 0 : totalSeats.hashCode());
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
		Flight other = (Flight) obj;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (flightPath == null) {
			if (other.flightPath != null)
				return false;
		} else if (!flightPath.equals(other.flightPath))
			return false;
		if (plane == null) {
			if (other.plane != null)
				return false;
		} else if (!plane.equals(other.plane))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		if (totalSeats == null) {
			if (other.totalSeats != null)
				return false;
		} else if (!totalSeats.equals(other.totalSeats))
			return false;
		return true;
	}
	
	
}
