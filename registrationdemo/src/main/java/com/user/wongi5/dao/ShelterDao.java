package com.user.wongi5.dao;

import java.util.List;
import com.user.wongi5.model.Shelter;

public interface ShelterDao {
	
	Shelter findByName(String shelterName);
	
	List<Shelter> findAll();

}
