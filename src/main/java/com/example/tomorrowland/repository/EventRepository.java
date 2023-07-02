package com.example.tomorrowland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tomorrowland.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
