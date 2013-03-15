package com.lee.study.itcastoa.domain;

import java.io.Serializable;
import java.util.Set;
/**
 * 岗位类
 * @author lee
 *	
 * 2013-2-24  下午11:42:58
 */
public class Post implements Serializable{


	private static final long serialVersionUID = 7301758373483948022L;
	
	private Long pid;
	private String pname;
	private String description;
	
	//多对多
	private Set<User> users;
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
