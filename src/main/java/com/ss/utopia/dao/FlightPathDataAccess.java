package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia.entity.FlightPath;

@Repository
public interface FlightPathDataAccess extends JpaRepository<FlightPath, Integer>{

}
