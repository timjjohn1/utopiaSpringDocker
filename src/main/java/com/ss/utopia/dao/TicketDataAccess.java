package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia.entity.Ticket;

@Repository
public interface TicketDataAccess extends JpaRepository<Ticket, Integer>{

}