package com.user.wongi5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.user.wongi5.model.Shelter;

public class ShelterDaoImpl implements ShelterDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	//@Override
	public Shelter findByName(String shelterName) {
		
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("shelterName", shelterName);
        
		String sql = "SELECT * FROM shelter WHERE shelterName=:shelterName";
		
        Shelter result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new ShelterMapper());
                    
        //new BeanPropertyRowMapper(Customer.class));
        
        return result;
	}
	
	//@Override
	public List<Shelter> findAll() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql = "SELECT * FROM shelter";
		
        List<Shelter> result = namedParameterJdbcTemplate.query(sql, params, new ShelterMapper());
        
        return result;
	}
	
	
	
	private static final class ShelterMapper implements RowMapper<Shelter> {

		public Shelter mapRow(ResultSet rs, int rowNum) throws SQLException {
			Shelter shelter = new Shelter();
			shelter.setShelterid(rs.getInt("shelterId"));
			shelter.setSheltername(rs.getString("shelterName"));
			shelter.setArea(rs.getString("area"));
			shelter.setBed(rs.getInt("bed"));
			return shelter;
		}
	}


}
