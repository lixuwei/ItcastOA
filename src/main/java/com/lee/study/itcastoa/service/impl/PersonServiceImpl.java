package com.lee.study.itcastoa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.study.itcastoa.dao.PersonDao;
import com.lee.study.itcastoa.domain.Person;
import com.lee.study.itcastoa.exception.PersonException;
import com.lee.study.itcastoa.service.PersonService;

@Service(value="personService")
public class PersonServiceImpl implements PersonService{

	@Resource
	private PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void save(Person person) throws PersonException  {
		
		try {
			personDao.save(person);
		} catch (Exception e) {
			throw new PersonException("用户保存失败",e);
		}
	}
	
	
}
