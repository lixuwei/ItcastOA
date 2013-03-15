package com.lee.study.itcastoa.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lee.study.itcastoa.baseDao.impl.BaseDaoImpl;
import com.lee.study.itcastoa.dao.UserDao;
import com.lee.study.itcastoa.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
	@SuppressWarnings("unchecked")
	public Collection<User> showUsers() {
		List<User> userList = sessionFactory.getCurrentSession().
				createQuery("from User u left outer join fetch u.department d inner join fetch u.posts p").list();
		return new HashSet<User>(userList);
	}
}
