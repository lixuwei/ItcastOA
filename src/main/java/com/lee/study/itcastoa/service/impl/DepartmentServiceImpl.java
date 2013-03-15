package com.lee.study.itcastoa.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lee.study.itcastoa.dao.DepartmentDao;
import com.lee.study.itcastoa.domain.Department;
import com.lee.study.itcastoa.domain.User;
import com.lee.study.itcastoa.exception.DepartmentException;
import com.lee.study.itcastoa.service.DepartmentService;

/**
 * 
 * @author lee
 *	
 * 2013-2-28  下午8:37:34
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Resource
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public void saveDepartment(Department department)throws DepartmentException {
		try {
			departmentDao.save(department);
		} catch (Exception e) {
			new DepartmentException("保存出错", e);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> showAllDepartment()throws DepartmentException {
		
		String hql = "from Department d";
		try {
			
			return departmentDao.findListByHql(hql);
		} catch (Exception e) {
			new DepartmentException("遍历Department信息出错", e);
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public void deleteDepartment(Long did) throws DepartmentException {
		try {
			/**
			 * 获取Department，并解除业务关系
			 */
			Department department = departmentDao.get(did);
			Set<User> users = department.getUsers();
			for (User user : users) {
				user.setDepartment(null);
			}
			departmentDao.delete(department);
		} catch (Exception e) {
			new DepartmentException("删除失败", e);
		}
	}

	@Override
	public Department findDepartmentById(Long did) throws DepartmentException {
		
		try {
			return departmentDao.get(did);
		} catch (Exception e) {
			new DepartmentException("获取Department失败",e);
		}
		return new Department();
	}

	@Override
	public void updateDepartmentByObject(Department department)
			throws DepartmentException {
		
		
		try {
			Department findDepartmentById = this.findDepartmentById(department.getDid());
			BeanUtils.copyProperties(department, findDepartmentById);
			departmentDao.update(findDepartmentById);
		} catch (Exception e) {
			new DepartmentException("更新Department失败",e);
		}
		
		
	}
	
	
	
}
