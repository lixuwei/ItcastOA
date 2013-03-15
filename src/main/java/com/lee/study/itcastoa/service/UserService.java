package com.lee.study.itcastoa.service;

import java.util.Collection;
import java.util.List;
import com.lee.study.itcastoa.domain.User;
import com.lee.study.itcastoa.exception.UserException;

public interface UserService {

	/**
	 * 显示用户列表
	 * @return
	 * @throws UserException
	 */
	List<User> getAllUser() throws UserException;
	/**
	 * 利用抓取的策略来获取数据
	 * @return
	 * @throws UserException
	 */
	Collection<User> getAllUsers() throws UserException;
	/**
	 * 根据Id删除用户记录
	 * @param uid
	 * @throws UserException
	 */
	void deleteUserById(Long uid) throws UserException;
	/**
	 * 添加一条记录
	 * @param user
	 * @throws UserException
	 */
	void addUser(User user) throws UserException;
	
	User getUserByID(Long uid) throws UserException;

}
