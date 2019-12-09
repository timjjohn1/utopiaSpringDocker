package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.utopia.entity.User;

@Repository
public interface UserDataAccess extends JpaRepository<User, Integer>{

}