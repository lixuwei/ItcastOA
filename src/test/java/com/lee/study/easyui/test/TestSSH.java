package com.lee.study.easyui.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSSH {

	ApplicationContext ac;
	
	@Before
	public void before(){
		ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-hibernate3.xml"});
	}
	
	@Test
	public void test(){                                        
		
	}

}
