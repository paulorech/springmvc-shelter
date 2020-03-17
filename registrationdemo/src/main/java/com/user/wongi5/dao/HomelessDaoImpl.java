package com.user.wongi5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.user.wongi5.model.Booking;
import com.user.wongi5.model.Homeless;
import com.user.wongi5.model.Shelter;
import com.user.wongi5.model.Student;

public class HomelessDaoImpl implements HomelessDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	//@Override
	public Homeless findByName(String name) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name );

		String sql = "SELECT * FROM homeless WHERE name=:name";

//        Homeless result = namedParameterJdbcTemplate.queryForObject(
//                    sql,
//                    params,
//                    new HomelessMapper());

		List<Homeless> results = namedParameterJdbcTemplate.query(sql, params, new HomelessMapper());

		if(results.size() == 0) {
			return null;
		}
		Homeless homeless = results.get(0);
		
		List<Shelter> shelterResults = findRegisteredShelters(homeless.getHomelessName());
		
		homeless.setRegisteredShelters(shelterResults);
		
		return homeless;

	}


	//@Override
	public List<Homeless> finAll() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM homeless";
		List<Homeless> result = namedParameterJdbcTemplate.query(sql, params, new HomelessMapper());
        
        return result;
        
	}

	private static final class HomelessMapper implements RowMapper<Homeless> {

		public Homeless mapRow(ResultSet rs, int rowNum) throws SQLException {
			Homeless homeless = new Homeless();
			homeless.setHomelessName(rs.getString("name"));
			homeless.setSpecialNotes(rs.getString("specialNotes"));
			return homeless;
		}
	}
	
public List<Shelter> findRegisteredShelters(String shelterName) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("shelterName", shelterName);
		
		String sql = "SELECT * FROM booking b, shelter s WHERE b.shelterid=s.shelterid AND s.sheltername=:shelterName;";
		
		List<Shelter> shelterResults = namedParameterJdbcTemplate.query(sql, params, new ShelterMapper());
		
		return shelterResults;
	}
	
	
	
	
}

