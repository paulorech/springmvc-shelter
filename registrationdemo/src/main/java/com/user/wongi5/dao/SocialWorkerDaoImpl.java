package com.user.wongi5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.user.wongi5.model.SocialWorker;


public class SocialWorkerDaoImpl implements SocialWorkerDao{
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	
	//@Override
	public SocialWorker findByName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        
		String sql = "SELECT * FROM social_worker WHERE name=:name";
		
        SocialWorker result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new SocialWorkerMapper());
                    
        //new BeanPropertyRowMapper(SocialWorker.class);
        
        return result;
	}
	
	//@Override
	public List<SocialWorker> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sql = "SELECT * FROM social_worker";
		
        List<SocialWorker> result = namedParameterJdbcTemplate.query(sql, params, new SocialWorkerMapper());
        
        return result;
	}
	
	
	private static final class SocialWorkerMapper implements RowMapper<SocialWorker> {

		public SocialWorker mapRow(ResultSet rs, int rowNum) throws SQLException {
			SocialWorker socialWorker = new SocialWorker();
			socialWorker.setSocialid(rs.getInt("socialid"));
			socialWorker.setUsername(rs.getString("username"));
			socialWorker.setPassword(rs.getString("password"));
			socialWorker.setPhone(rs.getString("phone"));
			socialWorker.setAddress(rs.getString("address"));
			
			return socialWorker;
		}
	}

	
	
	
	
}
