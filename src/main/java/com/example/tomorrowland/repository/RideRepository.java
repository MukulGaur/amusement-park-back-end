package com.example.tomorrowland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tomorrowland.entity.Ride;

public interface RideRepository extends JpaRepository<Ride, Long>{

}
