package com.lee.study.itcastoa.web.action;

import java.util.List;

import javax.annotation.Resource;


import com.lee.study.itcastoa.domain.Department;
import com.lee.study.itcastoa.exception.DepartmentException;
import com.lee.study.itcastoa.service.DepartmentService;
import com.lee.study.itcastoa.utils.OAActionSupport;
import com.opensymphony.xwork2.ActionContext;
/**
 * 处理Department请求
 * @author lee
 *	
 * 2013-3-4  上午10:23:45
 */
public class DepartmentAction extends OAActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3635733424017645533L;
	
	
	@Resource
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//从页面接收到的属性
	private Long did;
	
	private String dname;
	
	private String description;
	
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
	/**
	 * 获取所有的Department信息
	 * @return
	 */
	public String showAllDepartment(){
		
		List<Department> departments;
		try {
			departments = departmentService.showAllDepartment();
			ActionContext.getContext().put("departments", departments);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		
		return showList;
	}
	/**
	 * 处理删除操作
	 * @return
	 */
	public String deleteDepartment(){
		
		try {
			departmentService.deleteDepartment(did);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		
		return action2action;
	}
	/**
	 * 显示添加页面
	 * @return
	 */
	public String showAddUI(){
		return addUI;
	}
	/**
	 * 保存一个Department
	 * @return
	 */
	public String saveDepartment(){
		
		Department department = new Department();
		department.setDname(dname);
		department.setDescription(description);
		
		try {
			departmentService.saveDepartment(department);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		
		return action2action;
	}
	/**
	 * 显示Department更新页面
	 * @return
	 */
	public String showUpdateUI(){
		Department department = null;
		try {
			department = departmentService.findDepartmentById(did);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	/**
	 * 保存更新
	 * @return
	 */
	public String updateDepartment(){
		
		Department department = new Department();
		department.setDid(did);
		department.setDname(dname);
		department.setDescription(description);
		
		try {
			departmentService.updateDepartmentByObject(department);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		
		return action2action;
	}
}
