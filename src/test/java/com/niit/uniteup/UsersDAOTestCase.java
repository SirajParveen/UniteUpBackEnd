package com.niit.uniteup;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;

import com.niit.uniteup.dao.UsersDAO;
import com.niit.uniteup.model.Users;

public class UsersDAOTestCase {

	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static Users users;
	
	@Autowired  
	static UsersDAO  usersDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		users = (Users) context.getBean("users");
		usersDAO = (UsersDAO) context.getBean("usersDAO");
	}
	
	@Test
	public void saveOrUpdateTestCase()
	{
		users.setAddress("ecil");
		/*user.setDob(2-8-17);*/
		users.setGender("female");
		users.setMail("sujata@gmail.com");
		users.setMobile("888888888");
		users.setPassword("sujata");
		users.setRole("student");
		users.setUsername("sujata");

		boolean flag = usersDAO.saveOrUpdate(users);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = usersDAO.delete(users);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void listTestCase()
	{
		int recordsFromDB = usersDAO.list().size();

		assertEquals("listTestCase", 12, recordsFromDB);
	}
	
	@Test
	public void getuserTestCase()
	{
		users = (Users) usersDAO.getuser(01);
		
		assertEquals("getuserTestCase", null, users);
	}
	
	@Test
	public void oneuserTestCase()
	{
		users = (Users) usersDAO.oneuser(01);
		
		assertEquals("oneuserTestCase", null, users);
	}
	
	@Test
	public void authuserTestCase()
	{
		users = (Users) usersDAO.authuser("siraj", "siraj");
		
		assertEquals("authuserTestCase", null, users);
	}
	
	@Test
	public void profileofTestCase()
	{
		users = (Users) usersDAO.profileof("siraj");
		
		assertEquals("profileofTestCase", null, users);
	}
	
	@Test
	public void nonfriendsTestCase()
	{
		users = (Users) usersDAO.nonfriends(01, "siraj");
		
		assertEquals("nonfriendsTestCase", null, users);
	}
}
