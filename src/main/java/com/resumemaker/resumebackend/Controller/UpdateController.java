package com.resumemaker.resumebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.resumemaker.resumebackend.Dao.UpdateDao;
import com.resumemaker.resumebackend.Entities.Certification;
import com.resumemaker.resumebackend.Entities.Education;
import com.resumemaker.resumebackend.Entities.Experience;
import com.resumemaker.resumebackend.Entities.PersonalInfo;
import com.resumemaker.resumebackend.Entities.Projects;
import com.resumemaker.resumebackend.Entities.Skills;

@RestController
@CrossOrigin
public class UpdateController {

	@Autowired
	private UpdateDao updateDao;
	
	
	@PutMapping("update-education")
	public ResponseEntity<?> UpdateResume( @RequestBody List<Education> education){
		System.out.println(education);
		String response = updateDao.updateTables(education);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("update-experience")
	public ResponseEntity<?> UpdateExperience(@RequestBody List<Experience> experience){
		
		String response = updateDao.updateExperience(experience);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("update-certificate")
	public ResponseEntity<?> UpdateCertificate(@RequestBody List<Certification> certificate){
		
		String response = updateDao.updateCertificate(certificate);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("update-projects")
	public ResponseEntity<?> UpdateProjects(@RequestBody List<Projects> projects){
		
		String response = updateDao.updateProject(projects);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("update-skills")
	public ResponseEntity<?> UpdateSkills(@RequestBody List<Skills> skills){
		
		String response = updateDao.updateSkills(skills);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("update-personal")
	public ResponseEntity<?> UpdatePersonal(@RequestBody List<PersonalInfo> personal){
		
		String response = updateDao.updatePersonalInfo(personal);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
