package com.example.tomorrowland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tomorrowland.entity.Ride;
import com.example.tomorrowland.exception.RideNotFoundException;
import com.example.tomorrowland.repository.RideRepository;

@Service
public class RideService {
	
	private final RideRepository rideRepository;

    @Autowired
    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
    
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }
    
    public Ride getRideById(Long id) {
        return rideRepository.findById(id).orElseThrow(() -> new RideNotFoundException(id));
    }
    
    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }
    
    public Ride updateRide(Long id, Ride ride) {
    	Ride existingRide = rideRepository.findById(id).orElseThrow(() -> new RideNotFoundException(id));
        
        existingRide.setName(ride.getName());
        existingRide.setCategory(ride.getCategory());
        existingRide.setHeightRequirement(ride.getHeightRequirement());
        existingRide.setMinimumAge(ride.getMinimumAge());
        existingRide.setDurationMinutes(ride.getDurationMinutes());
        return rideRepository.save(existingRide);
    }
    
    public void deleteRide(Long id) {
    	rideRepository.findById(id).orElseThrow(() -> new RideNotFoundException(id));
    	rideRepository.deleteById(id);
    }

}
