package com.example.tomorrowland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tomorrowland.entity.Ride;
import com.example.tomorrowland.service.RideService;

@RestController
@RequestMapping("/api/ride")
public class RideController {
	
	private final RideService rideService;

    @Autowired
    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long id) {
        return new ResponseEntity<Ride>(rideService.getRideById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ride> createRide(@RequestBody Ride ride) {
        return new ResponseEntity<Ride>(rideService.createRide(ride), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ride> updateRide(@PathVariable Long id, @RequestBody Ride ride) {
        return new ResponseEntity<Ride>(rideService.updateRide(id, ride), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRide(@PathVariable Long id) {
        rideService.deleteRide(id);
        return new ResponseEntity<String>("Ride record deleted successfully !", HttpStatus.OK);
    }

}
