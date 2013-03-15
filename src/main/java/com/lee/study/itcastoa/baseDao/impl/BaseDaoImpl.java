package com.lee.study.itcastoa.baseDao.impl;

import java.lang.reflect.*;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lee.study.itcastoa.baseDao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T>{

	
	@Resource
	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) type;
			clazz = (Class<T>) pType.getActualTypeArguments()[0];
		}
	}
	/**
	 * 保存一个对象
	 * @param t
	 */
	public void save(T t) {
		this.getSession().merge(t);
	}
	/**
	 * 更新一个对象
	 * @param t
	 */
	public void update(T t) {
		this.getSession().update(t);
	}
	/**
	 * 通过ID获取某一个对象
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(Long id) {
		return (T) this.getSession().get(clazz, id);
	}
	
	/**
	 * 安装方法进行查询
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findListByHql(String hql,Object...params) {
		Query query = this.getSession().createQuery(hql);
		if(params.length != 0){
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}
	/**
	 * 以分页的方式获取表中，所有的数据
	 * @param pageNum
	 * @param pageMax
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAllWithPage(Integer pageNum, Integer pageMax) {
		String hql = "from "+clazz.getName()+" x";
		Query query = this.getSession().createQuery(hql)
				.setFirstResult((pageNum - 1)* pageMax).setMaxResults(pageMax);
		return query.list();
	}
	/**
	 * 通过Hql语句，进行分页，我们可以把分页参数动态添加到Hql语句中
	 * @param hql
	 * @param pageNum
	 * @param pageMax
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findListWithPage(String hql,Integer pageNum,Integer pageMax){
		Query query = this.getSession().createQuery(hql)
				.setFirstResult((pageNum - 1)* pageMax).setMaxResults(pageMax);
		return query.list();
	}
	/**
	 * 删除
	 * @param o
	 */
	public void delete(T t){
		this.getSession().delete(t);
	}
	/**
	 * 获取Session
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
