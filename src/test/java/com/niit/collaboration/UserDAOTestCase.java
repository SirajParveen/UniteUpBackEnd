package com.niit.collaboration;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static User user;
	
	@Autowired
	static UserDAO userDAO;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void isValidateCredentialsTestCase()
	{
		boolean flag = userDAO.isValidCredentials("niit", "niit");
		
		Assert.assertEquals("isValidateCredentialsTestCase", true, flag);
	}
	
	@Test
	public void createUserTestCase()
	{
		user.setId("siraj");
		user.setName("siraj");
		user.setPassword("siraj");
		user.setRole("student");
		
		boolean flag = userDAO.save(user);
		
		Assert.assertEquals("createUserTestCase", true, flag);
	}
	
	@Test
	public void getUserTestCase()
	{
		user = userDAO.get("manish");
		
		Assert.assertEquals("getUserTestCase", null, user);
	}
	
	@Test
	public void getAllUserTestCase()
	{
		int size = userDAO.list().size();
		
		//select count(*) from User
		Assert.assertEquals("getAllUserTestCase", 15, size);
	}
}
