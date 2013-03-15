package com.lee.study.itcastoa.domain;

import java.io.Serializable;
import java.util.Set;
/**
 * 部门类
 * @author lee
 *	
 * 2013-2-24  下午11:44:54
 */
public class Department implements Serializable{

	private static final long serialVersionUID = -4314371995544451681L;

	private Long did;
	
	private String dname;
	
	private String description;
	
	private Set<User> users;

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}



	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
}
