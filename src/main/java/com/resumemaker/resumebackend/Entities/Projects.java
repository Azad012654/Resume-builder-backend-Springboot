package com.resumemaker.resumebackend.Entities;

public class Projects {

	private String email;
	private int id;
	private String project_name;
	private String project_description;
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
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	@Override
	public String toString() {
		return "Projects [email=" + email + ", project_name=" + project_name + ", project_description="
				+ project_description + "]";
	}
	
}
