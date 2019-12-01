package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia.entity.CardInfo;

@Repository
public interface CardInfoDataAccess extends JpaRepository<CardInfo, String>{

}
