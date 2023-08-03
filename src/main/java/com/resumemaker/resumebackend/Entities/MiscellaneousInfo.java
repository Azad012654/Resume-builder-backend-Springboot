package com.resumemaker.resumebackend.Entities;

public class MiscellaneousInfo {

	private String email;
	private String name;
	private int phone;
	private String skills;
	private String certificate;
	private String resumeId;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	@Override
	public String toString() {
		return "MiscellaneousInfo [email=" + email + ", name=" + name + ", phone=" + phone + ", skills=" + skills
				+ ", certificate=" + certificate + "]";
	}
	
	
	
}
