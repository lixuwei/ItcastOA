package com.lee.study.itcastoa.service;

import java.util.List;

import com.lee.study.itcastoa.domain.Department;
import com.lee.study.itcastoa.exception.DepartmentException;

/**
 * 部门业务接口
 * @author lee
 *	
 * 2013-2-28  下午8:34:55
 */
public interface DepartmentService {
	
	void saveDepartment(Department department) throws DepartmentException;
	/**
	 * 获取所有的Department信息
	 * @return
	 */
	List<Department> showAllDepartment()throws DepartmentException;
	/**
	 *  删除Department
	 */
	void deleteDepartment(Long did)throws DepartmentException;
	/**
	 * 通过did得到Department
	 * @param did
	 * @return
	 */
	Department findDepartmentById(Long did) throws DepartmentException;
	/**
	 * 把页面上的对象与数据库中的对象进行更新
	 * @param department 
	 * @throws DepartmentException
	 */
	void updateDepartmentByObject(Department department) throws DepartmentException;
	
	
}
