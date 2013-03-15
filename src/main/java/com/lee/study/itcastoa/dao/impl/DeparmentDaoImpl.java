package com.lee.study.itcastoa.dao.impl;

import org.springframework.stereotype.Repository;

import com.lee.study.itcastoa.baseDao.impl.BaseDaoImpl;
import com.lee.study.itcastoa.dao.DepartmentDao;
import com.lee.study.itcastoa.domain.Department;
@Repository("departmentDao")
public class DeparmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

}
