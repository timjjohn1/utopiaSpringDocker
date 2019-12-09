package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia.entity.Booking;

@Repository
public interface BookingDataAccess extends JpaRepository<Booking, Integer>{

}