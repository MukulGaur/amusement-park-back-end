package com.example.tomorrowland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tomorrowland.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
