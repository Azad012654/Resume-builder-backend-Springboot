package com.resumemaker.resumebackend.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.resumemaker.resumebackend.Entities.Certification;
import com.resumemaker.resumebackend.Entities.Education;
import com.resumemaker.resumebackend.Entities.Experience;
import com.resumemaker.resumebackend.Entities.PersonalInfo;
import com.resumemaker.resumebackend.Entities.Projects;
import com.resumemaker.resumebackend.Entities.Skills;

@Repository
public class GetDao {

	private final JdbcTemplate jdbcTemplate;
	
	
    @Autowired
    public GetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate; 
        
    }
    
    
    
    public List<Education> getEducation(String email) {
        String sql = "SELECT id,email, start_date, end_date, institution_name, course, score,resumeId,createdAt FROM education WHERE email=?";

        return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, email);
            }
        }, new RowMapper<Education>() {
            @Override
            public Education mapRow(ResultSet rs, int rowNum) throws SQLException {
                Education education = new Education();
                education.setId(rs.getInt("id"));
                education.setEmail(rs.getString("email"));
                education.setStart(rs.getDate("start_date"));
                education.setEnd(rs.getDate("end_date"));
                education.setInstitute(rs.getString("institution_name"));
                education.setCourse(rs.getString("course"));
                education.setScore(rs.getDouble("score"));
                education.setResumeId(rs.getString("resumeid"));
                education.setCreatedAt(rs.getDate("createdAt"));
                
                return education;
            }
        });
    }
    
    public List<Experience> getExperience(String email){
    	String sql = "SELECT id,email,start_date,end_date,company,position,resumeId,description FROM experience WHERE email=?";
    	
    	return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
				
			}
    		
    	}, new RowMapper<Experience>() {
			@Override
			public Experience mapRow(ResultSet rs, int rowNum) throws SQLException {
				Experience experience = new Experience();
				experience.setId(rs.getInt("id"));
				experience.setEmail(rs.getString("email"));
				experience.setStart(rs.getDate("start_date"));
				experience.setEnd(rs.getDate("end_date"));
				experience.setCompany(rs.getString("company"));
				experience.setPosition(rs.getString("position"));
				experience.setResumeId(rs.getString("resumeId"));
				experience.setDescription(rs.getString("description"));
				return experience;
			}
    	});    
    }
    
    public List<Projects> getProjects(String email){
    	String sql = "SELECT id,email, project_name,project_description,resumeId FROM projects WHERE email=?";
    	
    	return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
				
			}
    		
    	}, new RowMapper<Projects>() {

			@Override
			public Projects mapRow(ResultSet rs, int rowNum) throws SQLException {
				Projects projects = new Projects();
				projects.setId(rs.getInt("id"));
				projects.setEmail(rs.getString("email"));
				projects.setProject_name(rs.getString("project_name"));
				projects.setProject_description(rs.getString("project_description"));
				projects.setResumeId(rs.getString("resumeId"));
				return projects;
			}
    		
    	});
    	
    }
    
    public List<Certification> getCertificate(String email){
    	
    	String sql = "SELECT id,email,certificate,resumeId FROM certificate WHERE email=?";
    	
    	return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
				
			}
    		
    	}, new RowMapper<Certification>() {

			@Override
			public Certification mapRow(ResultSet rs, int rowNum) throws SQLException {
				Certification certificate = new Certification();
				certificate.setId(rs.getInt("id"));
				certificate.setEmail(rs.getString("email"));
				certificate.setCertificate(rs.getString("certificate"));
				certificate.setResumeId(rs.getString("resumeId"));
				return certificate;
			}
    		
    	});
    	
    }
    
  public List<Skills> getSkills(String email){
    	
    	String sql = "SELECT id,email,skills,resumeId FROM skills WHERE email=?";
    	
    	return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
				
			}
    		
    	}, new RowMapper<Skills>() {

			@Override
			public Skills mapRow(ResultSet rs, int rowNum) throws SQLException {
				Skills skills = new Skills();
				skills.setId(rs.getInt("id"));
				skills.setEmail(rs.getString("email"));
				skills.setSkills(rs.getString("skills"));
				skills.setResumeId(rs.getString("resumeId"));
				return skills;
			}	
    	});
    }
  
  public List<PersonalInfo> getPersonalInfo(String email){
  	
  	String sql = "SELECT id,email,user_email,phone,name,summary,resumeId,createdAt FROM personal_info WHERE email=?";
  	
  	return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, email);
			
		}
		
	}, new RowMapper<PersonalInfo>() {

		@Override
		public PersonalInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			PersonalInfo personalInfo = new PersonalInfo();
			personalInfo.setId(rs.getInt("id"));
			personalInfo.setEmail(rs.getString("email"));
			personalInfo.setUseremail(rs.getString("user_email"));
			personalInfo.setPhone(rs.getString("phone"));
			personalInfo.setName(rs.getString("name"));
			personalInfo.setSummary(rs.getString("summary"));
			personalInfo.setResumeId(rs.getString("resumeId"));
			personalInfo.setCreatedAt(rs.getDate("createdAt"));
			return personalInfo;
		}	
	});
     }
  }

	
	

