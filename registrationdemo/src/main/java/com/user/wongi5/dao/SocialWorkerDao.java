package com.user.wongi5.dao;

import java.util.List;
import com.user.wongi5.model.SocialWorker;

public interface SocialWorkerDao {

	SocialWorker findByName(String name);
	
	List<SocialWorker> findAll();
	
	
	
}
