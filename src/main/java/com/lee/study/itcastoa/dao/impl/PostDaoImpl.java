package com.lee.study.itcastoa.dao.impl;

import org.springframework.stereotype.Repository;

import com.lee.study.itcastoa.baseDao.impl.BaseDaoImpl;
import com.lee.study.itcastoa.dao.PostDao;
import com.lee.study.itcastoa.domain.Post;

@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao{
	
}
