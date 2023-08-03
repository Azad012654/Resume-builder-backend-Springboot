package com.resumemaker.resumebackend.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.resumemaker.resumebackend.Entities.Certification;
import com.resumemaker.resumebackend.Entities.Education;
import com.resumemaker.resumebackend.Entities.Experience;
import com.resumemaker.resumebackend.Entities.PersonalInfo;
import com.resumemaker.resumebackend.Entities.Projects;
import com.resumemaker.resumebackend.Entities.Skills;
import com.resumemaker.resumebackend.Entities.User;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createUserTable() {
        String query = "CREATE TABLE IF NOT EXISTS Users (" +
                "username VARCHAR(150) NOT NULL, " +
                "email VARCHAR(150) PRIMARY KEY, " +
                "password VARCHAR(150) NOT NULL, " +
                "createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)";
        
        int update = this.jdbcTemplate.update(query);

       
        return update;
    }

    public String addUser(User user) {
        String sql = "INSERT INTO Users (username, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword());
        return "User Added Successfully!";
    }
    
    public int createEducationTable() {
    	String query = "CREATE TABLE IF NOT EXISTS Education (" +
    			"id SERIAL PRIMARY KEY , " +
    			"email VARCHAR(200) NOT NULL , " +
    		    "start_date DATE , " +
    		    "end_date DATE , " +
    		    "institution_name VARCHAR(300) NOT NULL, " +
    		    "course VARCHAR(100) NOT NULL, " + 
    		    "score DOUBLE PRECISION NOT NULL, " + 
    		    "resumeId VARCHAR(50),"+
    		    "createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
    		    "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
    	
    	int update = this.jdbcTemplate.update(query);
    	return update;
    }
    
    public String addEducation(List<Education> education) {
    	Exception message=null;
    	try {
    	String sql = "INSERT INTO Education (email,start_date,end_date,institution_name,course,resumeId,score ) VALUES (?,?,?,?,?,?,?)";
    	
    	jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            
    		@Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Education educations = education.get(i);
                ps.setString(1, educations.getEmail());    
                ps.setDate(2, educations.getStart());
                ps.setDate(3,educations.getEnd());
                ps.setString(4, educations.getInstitute());
                ps.setString(5, educations.getCourse());
                ps.setString(6, educations.getResumeId()); 
                ps.setDouble(7, educations.getScore());
                          }

            @Override
            public int getBatchSize() {
                return education.size();
            }
    	});
    	}catch(Exception e) {
    		message=e;
    		e.printStackTrace();
    	}
    	return (message !=null ? "Failed to Save Education Details due to some technical issues" : "Education added Successfully");
    }
    		// Experience Code
    
    public int createExperienceTable() {
    	
    	String query = "CREATE TABLE IF NOT EXISTS Experience( "+"id SERIAL PRIMARY KEY , " +
    	"email VARCHAR(100) NOT NULL, "+ 
    	"start_date DATE NOT NULL,"+
    	"end_date DATE NOT NULL,"+
    	"company VARCHAR(150) NOT NULL,"+
    	"position VARCHAR(150), "+
    	"resumeId VARCHAR(50),"+
    	"description VARCHAR(400))";
    	
    	int update = this.jdbcTemplate.update(query);
    	return update;
    }
    
    public String InsertToExperience(List<Experience> experience) {
    	Exception message = null;
    	try {
    		String sql = "INSERT INTO Experience (email,start_date,end_date,company,position,resumeId,description) VALUES (?,?,?,?,?,?,? )";
    		
    		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Experience experiences = experience.get(i);
					ps.setString(1, experiences.getEmail() );
					ps.setDate(2, experiences.getStart() );
					ps.setDate(3, experiences.getEnd() );
					ps.setString(4, experiences.getCompany() );
					ps.setString(5, experiences.getPosition() );
					ps.setString(6,experiences.getResumeId());
					ps.setString(7, experiences.getDescription());
					
					
				}

				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					return experience.size();
				}
    			
    		});
    		
    	}catch(Exception e) {
    		message = e;
    		e.printStackTrace();
    	}
    	
    	return (message !=null ? "Failed to Save Experience Details due to some technical issues" : "Experience added Successfully");
    }
    
    public int createProjectTable() {
    	String query = "CREATE TABLE IF NOT EXISTS Projects ("+ "id SERIAL PRIMARY KEY , " +
    "email VARCHAR(100) NOT NULL ," +
    "project_name VARCHAR(100) NOT NULL,"+ "project_description VARCHAR(400) NOT NULL," + "resumeId VARCHAR(50))";
    		int update = this.jdbcTemplate.update(query);    
    		return update;
    }
    
    public String InsertIntoProjects(List<Projects> projects) {
    	Exception message = null;
    	try {
    	String sql = "INSERT INTO Projects(email,project_name,project_description,resumeId) VALUES (?,?,?,?)";
    	
    	this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Projects project = projects.get(i);
				ps.setString(1, project.getEmail());
				ps.setString(2, project.getProject_name());
				ps.setString(3, project.getProject_description());
				ps.setString(4, project.getResumeId());
				
			}

			@Override
			public int getBatchSize() {
				
				return projects.size();
			}
    		
    	});
    	}catch(Exception e) {
    		message=e;
    		e.printStackTrace();
    	}
    	return (message !=null ? "Failed to Save Projects Details due to some technical issues" : "Experience added Successfully");
    }
    
    public int createSkillTable() {
    	String query = "CREATE TABLE IF NOT EXISTS Skills ("+"id SERIAL PRIMARY KEY , " +
    "email VARCHAR(200), "+"skills varchar(50)," + "resumeId VARCHAR(50))";
    	int update = this.jdbcTemplate.update(query);
    	return update;
    		
    }
    public String InsertIntoSkills(List<Skills> skills) {
    	Exception message = null;
    	try {
    		String sql = "INSERT INTO Skills (email,skills,resumeId) VALUES (?,?,?)";
    		
    		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Skills skill = skills.get(i);
					ps.setString(1, skill.getEmail());
					ps.setString(2, skill.getSkills());
					ps.setString(3, skill.getResumeId());
					
				}

				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					return skills.size();
				}
    			
    		});
    		
    	}catch(Exception e) {
    		message = e;
    		e.printStackTrace();
    	}
    	
    	return (message !=null ? "Failed to Save data" : "Skills Updated Succesfully");
    }
    
    public int createCertiicateTable() {
    	String query = "CREATE TABLE IF NOT EXISTS Certificate ("+"id SERIAL PRIMARY KEY , " +
    "email VARCHAR(200) NOT NULL, "+"certificate VARCHAR(100)," +"resumeId VARCHAR(50))";
    	int update = this.jdbcTemplate.update(query);
    	return update;
    }
    
    public String InserIntoCetificate(List<Certification> certificate) {
    	Exception message = null;
    	try {
    		String sql = "INSERT INTO Certificate(email, certificate,resumeId) VALUES (?,?,?)";
    		this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					
					Certification certification = certificate.get(i);
					ps.setString(1, certification.getEmail());
					ps.setString(2, certification.getCertificate());
					ps.setString(3, certification.getResumeId());
					
				}

				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					return certificate.size();
				}
    			
    		});
    	}catch(Exception e) {
    		message = e;
    		e.printStackTrace();
    	}
    	return (message !=null ? "Failed to Save data" : "Skills Updated Succesfully");
    }
    
    public int createPersonalInfoTable() {
    	
    	String query = "CREATE TABLE IF NOT EXISTS Personal_Info ("+ "id SERIAL PRIMARY KEY , " +
    	"email VARCHAR(100) NOT NULL,"+"user_email VARCHAR(100) NOT NULL,"+"phone VARCHAR(50) NOT NULL,"+"name VARCHAR(200) NOT NULL, "+"summary VARCHAR(800),"+ "resumeId VARCHAR(50),"+"createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
    	int update = this.jdbcTemplate.update(query);
    	return update;
    }
    public String InserIntoPersonalInfo(PersonalInfo personal) {
    	Exception message = null;
    	try {
    		String sql = "INSERT INTO Personal_Info(email,user_email,phone,name,summary,resumeId) VALUES (?,?,?,?,?,?)";
    		this.jdbcTemplate.update(sql,
    				personal.getEmail(),
    				personal.getUseremail(),
    				personal.getPhone(),
    				personal.getName(),
    				personal.getSummary(),
    				personal.getResumeId()); 
    				
    	}catch(Exception e) {
    		message = e;
    		e.printStackTrace();
    	}
    	return (message !=null ? "Failed to Save data" : "Personal Info Updated Succesfully");
    }
    
  }


