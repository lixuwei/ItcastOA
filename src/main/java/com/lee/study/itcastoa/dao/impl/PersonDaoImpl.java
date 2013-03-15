package com.lee.study.itcastoa.dao.impl;

import org.springframework.stereotype.Repository;
import com.lee.study.itcastoa.baseDao.impl.BaseDaoImpl;
import com.lee.study.itcastoa.dao.PersonDao;
import com.lee.study.itcastoa.domain.Person;

@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao{

}
