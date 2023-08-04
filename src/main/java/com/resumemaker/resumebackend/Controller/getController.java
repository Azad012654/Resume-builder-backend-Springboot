package com.resumemaker.resumebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.resumemaker.resumebackend.Dao.GetDao;
import com.resumemaker.resumebackend.Entities.Certification;
import com.resumemaker.resumebackend.Entities.Education;
import com.resumemaker.resumebackend.Entities.Experience;
import com.resumemaker.resumebackend.Entities.PersonalInfo;
import com.resumemaker.resumebackend.Entities.Projects;
import com.resumemaker.resumebackend.Entities.Skills;

@RestController
@CrossOrigin(origins = { "https://example.com", "https://my-first-resume-app.netlify.app" }, allowCredentials = "true")
public class getController {
	
	@Autowired
	private GetDao getDao;
	
	@GetMapping("get-education/{email}")
	public List<Education> getEducation(@PathVariable ("email") String email){
		
		List<Education> education = getDao.getEducation(email);
		System.out.println(education);
		return education;
	}
	
	@GetMapping("get-experience/{email}")
	public List<Experience> getExperience(@PathVariable ("email") String email){
		List<Experience> experience = getDao.getExperience(email);
		return experience;
	}
	
	@GetMapping("get-projects/{email}")
	public List<Projects> getProjects(@PathVariable ("email") String email){
		
		List<Projects> project = getDao.getProjects(email);
		return project;
		
	}
	
	@GetMapping("get-certificate/{email}")
	public List<Certification> getCertificate(@PathVariable ("email") String email){
		List<Certification> certificate = getDao.getCertificate(email);
		return certificate;
	}
	
	@GetMapping("get-skills/{email}")
	public List<Skills> getSkills(@PathVariable ("email") String email){
		List<Skills> skills = getDao.getSkills(email);
		return skills;
	}
	
	@GetMapping("get-personal/{email}")
	public List<PersonalInfo> getPersonal(@PathVariable ("email") String email){
		List<PersonalInfo> personalInfo = getDao.getPersonalInfo(email);
		return personalInfo;
	}
	
}
