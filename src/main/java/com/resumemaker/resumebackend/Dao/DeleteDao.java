package com.resumemaker.resumebackend.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String deleteResume(String resumeId) {
		Exception message = null;
		try {
		String sql = "DELETE FROM education WHERE resumeId = ?";
		this.jdbcTemplate.update(sql,resumeId);
		String sql2 = "DELETE FROM experience resumes WHERE resumeId = ?";
		this.jdbcTemplate.update(sql2,resumeId);
		String sql3 = "DELETE FROM certificate WHERE resumeId = ?";
		this.jdbcTemplate.update(sql3,resumeId);
		String sql4 = "DELETE FROM personal_info WHERE resumeId = ?";
		this.jdbcTemplate.update(sql4,resumeId);
		String sql5 = "DELETE FROM skills WHERE resumeId = ?";
		this.jdbcTemplate.update(sql5,resumeId);
		String sql6 = "DELETE FROM projects WHERE resumeId = ?";
		this.jdbcTemplate.update(sql6,resumeId);
		}catch(Exception e) {
			message = e;
			e.printStackTrace();
		}
		return (message !=null ? "Faced Error While Deleting" : "Successully deleted Resume");
	}
	
	public void deleteFields(List<Object> id) {
		System.out.println(id);
//		String sql = "DELETE FROM education WHERE resumeId = ?";
//		this.jdbcTemplate.update(sql,id);
		for (Object obj : id) {
		    Map<String, Object> keyValueMap = (Map<String, Object>) obj;
		    for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
		        String key = entry.getKey();
		        Object value = entry.getValue();
		        System.out.println("Key: "+key);
		        System.out.println("value: "+value);
		        int intValue = Integer.parseInt(value.toString());
		        if(key=="education") {
		        	System.out.println();
		        	String sql = "DELETE FROM education WHERE id = ?";
		        	this.jdbcTemplate.update(sql,intValue);
		        }
		        if(key=="experience") {
		        	String sql = "DELETE FROM experience WHERE id = ?";
		        	this.jdbcTemplate.update(sql,intValue);
		        }
		        if(key=="projects") {
		        	String sql = "DELETE FROM projects WHERE id = ?";
		        	this.jdbcTemplate.update(sql,intValue);
		        }
		        if(key=="skills") {
		        	String sql = "DELETE FROM skills WHERE id = ?";
		        	this.jdbcTemplate.update(sql,intValue);
		        }
		        if(key=="certificate") {
		        	String sql = "DELETE FROM certificate WHERE id = ?";
		        	this.jdbcTemplate.update(sql,intValue);
		        }
		    }
		}
		
		
	}
	
}
