package com.resumemaker.resumebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.resumemaker.resumebackend.Dao.UserDao;

@SpringBootApplication
public class ResumeBackendApplication implements CommandLineRunner {

	private final UserDao userDao;
	
	@Autowired
    public ResumeBackendApplication(UserDao userDao) {
        this.userDao = userDao;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ResumeBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(this.userDao.createUserTable());		
		this.userDao.createEducationTable();
		this.userDao.createExperienceTable();
		this.userDao.createProjectTable();
		this.userDao.createSkillTable();
		this.userDao.createCertiicateTable();
		this.userDao.createPersonalInfoTable();
		}

}
