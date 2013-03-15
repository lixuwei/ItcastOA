package com.lee.study.itcastoa.domain;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{

	private static final long serialVersionUID = 7890558099477056609L;

	private Long uid;
	private String uname;
	private String email;
	private String phone;
	
	//多对一
	private Department department;
	
	//多对多
	private Set<Post> posts;
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
}
