package com.resumemaker.resumebackend.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumemaker.resumebackend.Dao.UserDao;
import com.resumemaker.resumebackend.Entities.Certification;
import com.resumemaker.resumebackend.Entities.Education;
import com.resumemaker.resumebackend.Entities.Experience;
import com.resumemaker.resumebackend.Entities.PersonalInfo;
import com.resumemaker.resumebackend.Entities.Projects;
import com.resumemaker.resumebackend.Entities.Skills;
import com.resumemaker.resumebackend.Entities.User;

@RestController
@CrossOrigin(origins = { "https://example.com", "https://my-first-resume-app.netlify.app" }, allowCredentials = "true")
public class Controllers {
	
	@Autowired
	private UserDao userdao;
	
	
	@PostMapping("/add-user")
	public ResponseEntity<?> addUser(@RequestBody User user){
		
		String response = userdao.addUser(user);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/add-education")
	public ResponseEntity<?> addEducation(@RequestBody List<Education> education){
		
		String response = userdao.addEducation(education);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@PostMapping("/add-experience")
	public ResponseEntity<?> addExperience(@RequestBody List<Experience> experience){
	
		String response = userdao.InsertToExperience(experience);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
		
	}
	@PostMapping("/add-projects")
	public ResponseEntity<?> addProjects(@RequestBody List<Projects> projects ){
		System.out.println(projects);
		String response = userdao.InsertIntoProjects(projects);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("add-skills")
	public ResponseEntity<?> addSkills(@RequestBody List<Skills> skills){
		System.out.println(skills);
		String response = userdao.InsertIntoSkills(skills);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	@PostMapping("add-certificate")
	public ResponseEntity<?> addCertificate(@RequestBody List<Certification> certification){
		System.out.println(certification);
		String response = userdao.InserIntoCetificate(certification);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	@PostMapping("add-personalInfo")
	public ResponseEntity<?> addPersonalInfo(@RequestBody PersonalInfo personal){
		System.out.println(personal);
		String response = userdao.InserIntoPersonalInfo(personal);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
