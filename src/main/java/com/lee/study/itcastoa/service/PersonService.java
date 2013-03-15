package com.lee.study.itcastoa.service;

import com.lee.study.itcastoa.domain.Person;
import com.lee.study.itcastoa.exception.PersonException;
/**
 * Person Service
 * @author lee
 *	
 * 2013-2-23  下午5:00:58
 */
public interface PersonService {
	
	void save(Person person) throws PersonException ;
}
