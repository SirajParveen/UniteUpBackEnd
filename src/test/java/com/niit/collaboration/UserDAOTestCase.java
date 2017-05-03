/*package com.niit.collaboration;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UserDAOTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static User user;
	
	@Autowired  static UserDAO  userDAO;
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	//@Test
	
	public void validateCredentialsTestCase()
	{
		
	boolean flag =	  userDAO.isValidCredentials("01", "manish");
	
	Assert.assertEquals("validateCredentialsTestCase", true , flag);;
	;;;;;;;;
	;;;;;;;;;
		
	}
	
	
	//@Test
	public void createUserTestCase()
	{
		user.setId("01");
		user.setName("manish");
		user.setName("manish");
		user.setRole("Student");
		user.setAddress("Andheri W");
		user.setMobile("999999999");
	       boolean flag =	userDAO.save(user);
	       
	       assertEquals("createUserTestCase ",true, flag);
	}
	
	
	//@Test
	public void updateUserTestCase()
	{
		user.setId("01");
		user.setName("manish");
		user.setName("manish");
		user.setRole("Student");
		user.setAddress("Andheri W");
		user.setMobile("888888888");
	       boolean flag =	userDAO.update(user);
	       
	       assertEquals("createUserTestCase ",true, flag);
	}
	
	@Test
	public void getUserTestCase()
	{
		user =  userDAO.get("01");
		
		assertEquals("getUserTestCase", null, user);	
	}
	
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users=  userDAO.list();
		
		//select count(*) from c_user_detail
		assertEquals("getAllUsersTestCase", 28, users.size());
	}
}
*/