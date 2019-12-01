package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia.entity.Flight;

@Repository
public interface FlightDataAccess extends JpaRepository<Flight, Integer>{

}
