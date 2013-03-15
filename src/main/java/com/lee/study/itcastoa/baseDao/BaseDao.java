package com.lee.study.itcastoa.baseDao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 保存一个对象
	 * @param t
	 */
	public void save(T t) ;
	/**
	 * 更新一个对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 通过ID获取某一个对象
	 * @param id
	 * @return
	 */
	public T get(Long id);
	/**
	 * 安装方法进行查询
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> findListByHql(String hql,Object...params) ;
	/**
	 * 以分页的方式获取表中，所有的数据
	 * @param pageNum
	 * @param pageMax
	 * @return
	 */
	public List<T> findAllWithPage(Integer pageNum, Integer pageMax) ;
	/**
	 * 通过Hql语句，进行分页，我们可以把分页参数动态添加到Hql语句中
	 * @param hql
	 * @param pageNum
	 * @param pageMax
	 * @return
	 */
	public List<T> findListWithPage(String hql,Integer pageNum,Integer pageMax);
	/**
	 * 删除
	 * @param o
	 */
	public void delete(T t);
}
