package com.niit.uniteup;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.uniteup.dao.UsersDAO;
import com.niit.uniteup.model.Users;

public class UsersDAOTestCase {

	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static Users user;
	
	@Autowired  static UsersDAO  userDAO;
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (Users) context.getBean("user");
		
		userDAO = (UsersDAO) context.getBean("userDAO");
	}
}
