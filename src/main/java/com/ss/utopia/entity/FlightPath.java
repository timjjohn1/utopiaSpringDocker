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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name = "flightPath", schema = "utopia")
public class FlightPath implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2018515413275450662L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flightPathId", updatable = false, unique = true)
	private Integer flightPathId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "srcAirport", nullable = false)
	private Airport srcAirport;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "destAirport", nullable = false)
	private Airport destAirport;

	@OneToMany(mappedBy = "flightPath")
	@JsonIgnore
	private Collection<Flight> flights;
	
	public FlightPath() {}
	
	public FlightPath(Integer flightPathId, Airport srcAirport, Airport destAirport) {
		super();
		this.flightPathId = flightPathId;
		this.srcAirport = srcAirport;
		this.destAirport = destAirport;
	}

	/**
	 * @return the flightPathId
	 */
	public Integer getFlightPathId() {
		return flightPathId;
	}

	/**
	 * @param flightPathId the flightPathId to set
	 */
	public void setFlightPathId(Integer flightPathId) {
		this.flightPathId = flightPathId;
	}

	/**
	 * @return the srcAirport
	 */
	public Airport getSrcAirport() {
		return srcAirport;
	}

	/**
	 * @param srcAirport the srcAirport to set
	 */
	public void setSrcAirport(Airport srcAirport) {
		this.srcAirport = srcAirport;
	}

	/**
	 * @return the destAirport
	 */
	public Airport getDestAirport() {
		return destAirport;
	}

	/**
	 * @param destAirport the destAirport to set
	 */
	public void setDestAirport(Airport destAirport) {
		this.destAirport = destAirport;
	}

	
	
	@Override
	public String toString() {
		return "FlightPath [flightPathId=" + flightPathId + ", srcAirport=" + srcAirport + ", destAirport="
				+ destAirport + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destAirport == null) ? 0 : destAirport.hashCode());
		result = prime * result + ((flightPathId == null) ? 0 : flightPathId.hashCode());
		result = prime * result + ((flights == null) ? 0 : flights.hashCode());
		result = prime * result + ((srcAirport == null) ? 0 : srcAirport.hashCode());
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
		FlightPath other = (FlightPath) obj;
		if (destAirport == null) {
			if (other.destAirport != null)
				return false;
		} else if (!destAirport.equals(other.destAirport))
			return false;
		if (flightPathId == null) {
			if (other.flightPathId != null)
				return false;
		} else if (!flightPathId.equals(other.flightPathId))
			return false;
		if (flights == null) {
			if (other.flights != null)
				return false;
		} else if (!flights.equals(other.flights))
			return false;
		if (srcAirport == null) {
			if (other.srcAirport != null)
				return false;
		} else if (!srcAirport.equals(other.srcAirport))
			return false;
		return true;
	}



	
	
}
