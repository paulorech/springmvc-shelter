package com.user.wongi5.model;

import java.util.List;

public class Homeless {
	
	private int homelessId;
	private String homelessName;
	private String specialNotes;
	private List<Shelter> registeredShelters;
	
	
	public int getHomelessId() {
		return homelessId;
	}
	public void setHomelessId(int homelessId) {
		this.homelessId = homelessId;
	}
	public String getHomelessName() {
		return homelessName;
	}
	public void setHomelessName(String homelessName) {
		this.homelessName = homelessName;
	}
	public String getSpecialNotes() {
		return specialNotes;
	}
	public void setSpecialNotes(String specialNotes) {
		this.specialNotes = specialNotes;
	}
	public List<Shelter> getRegisteredShelters() {
		return registeredShelters;
	}
	public void setRegisteredShelters(List<Shelter> registeredShelters) {
		this.registeredShelters = registeredShelters;
	}
	
	
	
	
	

}
