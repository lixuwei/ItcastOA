package com.lee.study.itcastoa.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lee.study.itcastoa.dao.UserDao;
import com.lee.study.itcastoa.domain.User;
import com.lee.study.itcastoa.exception.UserException;
import com.lee.study.itcastoa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() throws UserException{
		
		try {
			String hql = "from User u";
			List<User> findListByHql = userDao.findListByHql(hql);
			
			return findListByHql;
		} catch (Exception e) {
			new UserException("显示列表", e);
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public void deleteUserById(Long uid) throws UserException {
		try {
			
		User user = userDao.get(uid);
		userDao.delete(user);
		} catch (Exception e) {
			new UserException("删除用户识别",e);
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> getAllUsers() throws UserException {
		try {
			Collection<User> showUsers = userDao.showUsers();
			return showUsers;
		} catch (Exception e) {
			new UserException("抓取数据失败",e);
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public void addUser(User user) throws UserException {
		try {
			userDao.save(user);
		} catch (Exception e) {
			new UserException("保存user失败",e);
		}
	}

	@Override
	public User getUserByID(Long uid) throws UserException {
		User user = new User();
		try {
			User getUser = userDao.get(uid);
			BeanUtils.copyProperties(getUser, user);
		} catch (Exception e) {
			new UserException("获取User失败",e);
		}
		return user;
	}
	
}
