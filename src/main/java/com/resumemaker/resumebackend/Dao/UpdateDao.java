package com.resumemaker.resumebackend.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.resumemaker.resumebackend.Entities.Certification;
import com.resumemaker.resumebackend.Entities.Education;
import com.resumemaker.resumebackend.Entities.Experience;
import com.resumemaker.resumebackend.Entities.PersonalInfo;
import com.resumemaker.resumebackend.Entities.Projects;
import com.resumemaker.resumebackend.Entities.Skills;

@Repository
public class UpdateDao {

	@Autowired
  private JdbcTemplate jdbcTemplate;
	

	
	public String updateTables(List<Education> education) {
		System.out.println(education);
		Exception message = null;
		try {
			
			String sql = "INSERT INTO education (id, email, start_date, end_date, institution_name, course, score, resumeId) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                    "ON CONFLICT (id) DO UPDATE " +
                    "SET id = ?, email = ?, start_date = ?, end_date = ?, institution_name = ?, course = ?, score = ?, resumeId = ?";
	        
			
	        // Use batchUpdate to perform batch updates
			this.jdbcTemplate.batchUpdate(sql, education, education.size(),
	                (ps, educations) -> {
	                    ps.setInt(1, educations.getId());
	                    ps.setString(2, educations.getEmail());
	                    ps.setDate(3, educations.getStart());
	                    ps.setDate(4, educations.getEnd());
	                    ps.setString(5, educations.getInstitute());
	                    ps.setString(6, educations.getCourse());
	                    ps.setDouble(7, educations.getScore());
	                    ps.setString(8, educations.getResumeId());

	                    // For the ON DUPLICATE KEY UPDATE part
	                    ps.setInt(9, educations.getId());
	                    ps.setString(10, educations.getEmail());
	                    ps.setDate(11, educations.getStart());
	                    ps.setDate(12, educations.getEnd());
	                    ps.setString(13, educations.getInstitute());
	                    ps.setString(14, educations.getCourse());
	                    ps.setDouble(15, educations.getScore());
	                    ps.setString(16, educations.getResumeId());
	                });
		
		}catch(Exception e) {
			message = e;
			e.printStackTrace();
		}
		
		return (message !=null ? "Failed to update Resume" : "Update Successfull");
		
	}
	
	public String updateExperience(List<Experience> experience) {
		
		Exception message = null;
		try {
			
			String sql = "INSERT INTO experience (id, email, start_date, end_date, company, position, resumeId, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                    "ON CONFLICT (id) DO UPDATE " +
                    "SET id = ?, email = ?, start_date = ?, end_date = ?, company = ?, position = ?, resumeId = ?, description = ?";
	        
			
	        // Use batchUpdate to perform batch updates
			this.jdbcTemplate.batchUpdate(sql, experience, experience.size(),
	                (ps, educations) -> {
	                    ps.setInt(1, educations.getId());
	                    ps.setString(2, educations.getEmail());
	                    ps.setDate(3, educations.getStart());
	                    ps.setDate(4, educations.getEnd());
	                    ps.setString(5, educations.getCompany());
	                    ps.setString(6, educations.getPosition());
	                    ps.setString(7, educations.getResumeId());
	                    ps.setString(8, educations.getDescription());

	                    // For the ON DUPLICATE KEY UPDATE part
	                    ps.setInt(9, educations.getId());
	                    ps.setString(10, educations.getEmail());
	                    ps.setDate(11, educations.getStart());
	                    ps.setDate(12, educations.getEnd());
	                    ps.setString(13, educations.getCompany());
	                    ps.setString(14, educations.getPosition());
	                    ps.setString(15, educations.getResumeId());
	                    ps.setString(16, educations.getDescription());
	                });
		
		}catch(Exception e) {
			message = e;
			e.printStackTrace();
		}
		
		return (message !=null ? "Failed to update Resume" : "Update Successfull");
		
	}
	
public String updateCertificate(List<Certification> certification) {
		
		Exception message = null;
		try {
			
			String sql = "INSERT INTO certificate (id, email, certificate,resumeId) " +
                    "VALUES (?, ?, ?, ?) " +
                    "ON CONFLICT (id) DO UPDATE " +
                    "SET id = ?, email = ?, certificate = ?, resumeId = ?";
	        
			
	        // Use batchUpdate to perform batch updates
			this.jdbcTemplate.batchUpdate(sql, certification, certification.size(),
	                (ps, educations) -> {
	                    ps.setInt(1, educations.getId());
	                    ps.setString(2, educations.getEmail());
	                    ps.setString(3, educations.getCertificate());
	                    ps.setString(4, educations.getResumeId());
	                   

	                    // For the ON DUPLICATE KEY UPDATE part
	                    ps.setInt(5, educations.getId());
	                    ps.setString(6, educations.getEmail());
	                    ps.setString(7, educations.getCertificate());
	                    ps.setString(8, educations.getResumeId());
	                });
		
		}catch(Exception e) {
			message = e;
			e.printStackTrace();
		}
		
		return (message !=null ? "Failed to update Resume" : "Update Successfull");
		
	}

public String updateProject(List<Projects> projects) {
	
	Exception message = null;
	try {
		
		String sql = "INSERT INTO projects (id, email, project_name,project_description,resumeId) " +
                "VALUES (?, ?, ?, ?,?) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET id = ?, email = ?,  project_name=?,project_description=?,resumeId=?";
        
		
        // Use batchUpdate to perform batch updates
		this.jdbcTemplate.batchUpdate(sql, projects, projects.size(),
                (ps, educations) -> {
                    ps.setInt(1, educations.getId());
                    ps.setString(2, educations.getEmail());
                    ps.setString(3, educations.getProject_name());
                    ps.setString(4, educations.getProject_description());
                    ps.setString(5, educations.getResumeId());
                   

                    // For the ON DUPLICATE KEY UPDATE part
                    ps.setInt(6, educations.getId());
                    ps.setString(7, educations.getEmail());
                    ps.setString(8, educations.getProject_name());
                    ps.setString(9, educations.getProject_description());
                    ps.setString(10, educations.getResumeId());
                });
	
	}catch(Exception e) {
		message = e;
		e.printStackTrace();
	}
	
	return (message !=null ? "Failed to update Resume" : "Update Successfull");
	
}

public String updateSkills(List<Skills> skills) {
	
	Exception message = null;
	try {
		
		String sql = "INSERT INTO skills (id, email,skills,resumeId) " +
                "VALUES (?, ?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET id = ?, email = ?,skills=? ,resumeId=?";
        
		
        // Use batchUpdate to perform batch updates
		this.jdbcTemplate.batchUpdate(sql, skills, skills.size(),
                (ps, educations) -> {
                    ps.setInt(1, educations.getId());
                    ps.setString(2, educations.getEmail());
                    ps.setString(3, educations.getSkills());
                    ps.setString(4, educations.getResumeId());
                    
                   

                    // For the ON DUPLICATE KEY UPDATE part
                    ps.setInt(5, educations.getId());
                    ps.setString(6, educations.getEmail());
                    ps.setString(7, educations.getSkills());
                    ps.setString(8, educations.getResumeId());
                });
	
	}catch(Exception e) {
		message = e;
		e.printStackTrace();
	}
	
	return (message !=null ? "Failed to update Resume" : "Update Successfull");
	
}

public String updatePersonalInfo(List<PersonalInfo> personal) {
	
	Exception message = null;
	try {
		
		String sql = "INSERT INTO personal_info (id, email, user_email,phone,name,summary,resumeId)" +
                "VALUES (?, ?, ?, ?,?,?,?) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET id=?, email=?, user_email=?,phone=?,name=?,summary=?,resumeId=?";
        
		
        // Use batchUpdate to perform batch updates
		this.jdbcTemplate.batchUpdate(sql, personal, personal.size(),
                (ps, educations) -> {
                    ps.setInt(1, educations.getId());
                    ps.setString(2, educations.getEmail());
                    ps.setString(3, educations.getUseremail());
                    ps.setString(4, educations.getPhone());
                    ps.setString(5, educations.getName());
                    ps.setString(6, educations.getSummary());
                    ps.setString(7, educations.getResumeId());
                    
                    // For the ON DUPLICATE KEY UPDATE part
                    ps.setInt(8, educations.getId());
                    ps.setString(9, educations.getEmail());
                    ps.setString(10, educations.getUseremail());
                    ps.setString(11, educations.getPhone());
                    ps.setString(12, educations.getName());
                    ps.setString(13, educations.getSummary());
                    ps.setString(14, educations.getResumeId());
                });
	
	}catch(Exception e) {
		message = e;
		e.printStackTrace();
	}
	
	return (message !=null ? "Failed to update Resume" : "Update Successfull");
	
}
	
}
