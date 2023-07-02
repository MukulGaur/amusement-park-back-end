package com.example.tomorrowland.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rides")
public class Ride {
	
	@Id
	private Long id;
    private String name;
    private String category;
    private Integer heightRequirement;
    private Integer minimumAge;
    private Integer durationMinutes;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getHeightRequirement() {
		return heightRequirement;
	}
	public void setHeightRequirement(Integer heightRequirement) {
		this.heightRequirement = heightRequirement;
	}
	public Integer getMinimumAge() {
		return minimumAge;
	}
	public void setMinimumAge(Integer minimumAge) {
		this.minimumAge = minimumAge;
	}
	public Integer getDurationMinutes() {
		return durationMinutes;
	}
	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

}
