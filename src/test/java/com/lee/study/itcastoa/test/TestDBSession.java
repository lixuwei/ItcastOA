package com.lee.study.itcastoa.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lee.study.itcastoa.domain.Person;
import com.lee.study.itcastoa.exception.PersonException;
import com.lee.study.itcastoa.service.PersonService;


public class TestDBSession {

	ApplicationContext ac;
	
	@Before
	public void before(){
		ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-hibernate3.xml"});
	}
	
	@Test
	public void test(){
		
	
		
		/*Person person = new Person();
		person.setPname("Alex");
		
		PersonService bean = (PersonService) ac.getBean("personService");
		try {
			bean.save(person);
		} catch (PersonException e) {
			e.printStackTrace();
		}*/
	}
}
