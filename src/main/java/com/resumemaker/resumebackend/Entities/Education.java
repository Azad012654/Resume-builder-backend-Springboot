package com.resumemaker.resumebackend.Entities;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Education {

	private String email;
	private int id;
	
	private Date start;
	private Date end;
	private String institute;
	private String course;
	private double score;
	private String resumeId;
	private Date createdAt;
	
	
	
	
	
	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getResumeId() {
		return resumeId;
	}


	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}


	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	@Override
	public String toString() {
		return "Education [email=" + email + ", start=" + start + ", end=" + end + ", institute=" + institute
				+ ", course=" + course + ", score=" + score + "]";
	}

	
	
	
	
}
