package com.niit.uniteup;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.uniteup.dao.ForumDAO;
import com.niit.uniteup.model.Forum;

public class ForumDAOTestCase {

	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static Forum forum;
	
	@Autowired  
	static ForumDAO  forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		forum = (Forum) context.getBean("forum");
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}
	
	@Test
	public void saveOrUpdateTestCase()
	{
		forum.setDescription("forum");
		/*forum.setDoc(03-04-2017);*/
		forum.setName("forum");
		forum.setTopic("forum");
		forum.setUserid("03");

		boolean flag = forumDAO.saveOrUpdate(forum);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = forumDAO.delete(forum);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void listTestCase()
	{
		int recordsFromDB = forumDAO.list().size();

		assertEquals("listTestCase", 12, recordsFromDB);
	}
	
	@Test
	public void getforumTestCase()
	{
		forum = (Forum) forumDAO.getforum(04);
		
		assertEquals("getforumTestCase", null, forum);
	}
	
	@Test
	public void userlistTestCase()
	{
		forum = (Forum) forumDAO.userlist();
		
		assertEquals("userlistTestCase", null, forum);
	}
	
	@Test
	public void getTestCase()
	{
		forum = (Forum) forumDAO.get(9);
		
		assertEquals("getTestCase", null, forum);
	}
}
