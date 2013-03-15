package com.lee.study.itcastoa.dao;

import java.util.Collection;

import com.lee.study.itcastoa.baseDao.BaseDao;
import com.lee.study.itcastoa.domain.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * 根据抓取的方式，抽取关联的用户 部门 岗位信息
	 * @return
	 */
	public Collection<User> showUsers();
}
