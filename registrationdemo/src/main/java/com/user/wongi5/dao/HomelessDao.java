package com.user.wongi5.dao;

import java.util.List;

import com.user.wongi5.model.Booking;
import com.user.wongi5.model.Homeless;
import com.user.wongi5.model.Shelter;

public interface HomelessDao {
	
	
	Homeless findByName(String name);
	
	List<Homeless> finAll();
	
	List<Shelter> findRegisteredShelters(String shelterName);
	

}

