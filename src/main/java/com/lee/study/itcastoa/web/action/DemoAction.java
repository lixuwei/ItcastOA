package com.lee.study.itcastoa.web.action;

public class DemoAction {

	
	private String name;

	public String getName() {
		return name;
	}

	public String reponseJSON(){
		this.name = "lixuwei";
		return "printJSON";
	}
	
}
