package com.resumemaker.resumebackend.Entities;

import java.sql.Date;

public class PersonalInfo {

	private String email;
	private int id;
	private String useremail;
	private String phone;
	private String name;
	private String summary;
	private String resumeId;
	private String resumename;
	private Date createdAt;
	
	
	
	public String getResumename() {
		return resumename;
	}
	public void setResumename(String resumename) {
		this.resumename = resumename;
	}
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PersonalInfo [email=" + email + ", id=" + id + ", useremail=" + useremail + ", phone=" + phone
				+ ", name=" + name + ", summary=" + summary + ", resumeId=" + resumeId + ", resumename=" + resumename
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
}
