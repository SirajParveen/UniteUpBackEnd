package com.niit.uniteup;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.uniteup.dao.FriendDAO;
import com.niit.uniteup.model.Friend;

public class FriendDAOTestCase {

	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static Friend friend;
	
	@Autowired  
	static FriendDAO  friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		friend = (Friend) context.getBean("friend");
		friendDAO = (FriendDAO) context.getBean("friendDAO");
	}
	
	@Test
	public void saveOrUpdateTestCase()
	{
		friend.setFriendid("9");
		friend.setIsonline('N');
		friend.setStatus('o');
		friend.setUserid("09");

		boolean flag = friendDAO.saveOrUpdate(friend);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = friendDAO.delete(friend);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void newrequestTestCase()
	{
		Friend flag = friendDAO.newrequest("03", "04"); 

		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void getfriendlistTestCase()
	{
		int recordsFromDB = friendDAO.getfriendlist("09").size();

		assertEquals("getfriendlistTestCase", 12, recordsFromDB);
	}
	
	@Test
	public void getrequestlistTestCase()
	{
		int recordsFromDB = friendDAO.getrequestlist("04").size();

		assertEquals("getrequestlistTestCase", 12, recordsFromDB);
	}
	
	@Test
	public void setonlineTestCase()
	{
		List<Friend> flag = friendDAO.setonline("04");
		
		assertEquals("setonlineTestCase", true, flag);
	}
}
