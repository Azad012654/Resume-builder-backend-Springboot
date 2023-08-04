package com.resumemaker.resumebackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumemaker.resumebackend.Dao.DeleteDao;

@RestController
@CrossOrigin(origins = { "https://example.com", "https://my-first-resume-app.netlify.app" }, allowCredentials = "true")
public class DeleteController {
	
	@Autowired
	private DeleteDao delete;

	@DeleteMapping("delete-resume/{resumeId}")
	public ResponseEntity<String> deleteResume(@PathVariable String resumeId){
		
		String response = delete.deleteResume(resumeId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("delete-fields")
	public void deleteFields(@RequestBody List<Object> ob) {
		delete.deleteFields(ob);
	}
	
}
