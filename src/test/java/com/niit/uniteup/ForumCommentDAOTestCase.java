package com.niit.uniteup;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.uniteup.dao.ForumCommentDAO;
import com.niit.uniteup.model.ForumComment;

public class ForumCommentDAOTestCase {

	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static ForumComment forumComment;
	
	@Autowired  
	static ForumCommentDAO  forumCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		forumComment = (ForumComment) context.getBean("forumComment");
		forumCommentDAO = (ForumCommentDAO) context.getBean("forumCommentDAO");
	}
	
	@Test
	public void saveOrUpdateTestCase()
	{
		forumComment.setComment("comment");
		/*forumComment.setCommenttime(02-03-2017);*/
		forumComment.setForumid(03);
		forumComment.setUserid(03);

		boolean flag = forumCommentDAO.saveOrUpdate(forumComment);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = forumCommentDAO.delete(forumComment);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void listTestCase()
	{
		int recordsFromDB = forumCommentDAO.list(02).size();

		assertEquals("listTestCase", 12, recordsFromDB);
	}
}
