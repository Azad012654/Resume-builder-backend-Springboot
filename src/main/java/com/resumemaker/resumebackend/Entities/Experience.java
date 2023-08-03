package com.resumemaker.resumebackend.Entities;

import java.sql.Date;

public class Experience {

String email;
private int id;
private Date start;
private Date end;
String company;
String position;
String description;
private String resumeId;


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
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Experience [email=" + email + ", start=" + start + ", end=" + end + ", company=" + company + ", position="
			+ position + ", description=" + description + "]";
}




	
}
