package com.ss.utopia.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity 
@Table(name = "airport", schema = "utopia")
public class Airport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8325930518684136263L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airportCode", updatable = false, unique = true, nullable = false)
	private String flightPathId;
	
	@Column(name = "airportCode")
	private String airportCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip")
	private Integer zip;
	
	@OneToMany(mappedBy = "srcAiport")
	private Collection<FlightPath> srcAirports;
	
	@OneToMany(mappedBy = "destAirport")
	private Collection<FlightPath> destAirports;

	public Airport(String flightPathId, String airportCode, String city, Integer zip,
			Collection<FlightPath> srcAirports, Collection<FlightPath> destAirports) {
		super();
		this.flightPathId = flightPathId;
		this.airportCode = airportCode;
		this.city = city;
		this.zip = zip;
		this.srcAirports = srcAirports;
		this.destAirports = destAirports;
	}

	/**
	 * @return the flightPathId
	 */
	public String getFlightPathId() {
		return flightPathId;
	}

	/**
	 * @param flightPathId the flightPathId to set
	 */
	public void setFlightPathId(String flightPathId) {
		this.flightPathId = flightPathId;
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
	 * @return the srcAirports
	 */
	public Collection<FlightPath> getSrcAirports() {
		return srcAirports;
	}

	/**
	 * @param srcAirports the srcAirports to set
	 */
	public void setSrcAirports(Collection<FlightPath> srcAirports) {
		this.srcAirports = srcAirports;
	}

	/**
	 * @return the destAirports
	 */
	public Collection<FlightPath> getDestAirports() {
		return destAirports;
	}

	/**
	 * @param destAirports the destAirports to set
	 */
	public void setDestAirports(Collection<FlightPath> destAirports) {
		this.destAirports = destAirports;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportCode == null) ? 0 : airportCode.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((destAirports == null) ? 0 : destAirports.hashCode());
		result = prime * result + ((flightPathId == null) ? 0 : flightPathId.hashCode());
		result = prime * result + ((srcAirports == null) ? 0 : srcAirports.hashCode());
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
		Airport other = (Airport) obj;
		if (airportCode == null) {
			if (other.airportCode != null)
				return false;
		} else if (!airportCode.equals(other.airportCode))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (destAirports == null) {
			if (other.destAirports != null)
				return false;
		} else if (!destAirports.equals(other.destAirports))
			return false;
		if (flightPathId == null) {
			if (other.flightPathId != null)
				return false;
		} else if (!flightPathId.equals(other.flightPathId))
			return false;
		if (srcAirports == null) {
			if (other.srcAirports != null)
				return false;
		} else if (!srcAirports.equals(other.srcAirports))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	
	
}
