package com.lee.study.itcastoa.test;

import org.junit.Test;

import com.lee.study.itcastoa.domain.Department;
import com.lee.study.itcastoa.exception.DepartmentException;
import com.lee.study.itcastoa.service.DepartmentService;

public class DepartmentTest extends TestDBSession{
	
	@Test
	public void addDepartment(){									
		DepartmentService service = (DepartmentService) ac.getBean("departmentService");
		Department department = new Department();
		department.setDescription("研发部加班不给钱");
		department.setDname("lixuwei");
		try {
			service.saveDepartment(department);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		
	}
}
