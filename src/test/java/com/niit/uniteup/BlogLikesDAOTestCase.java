package com.niit.uniteup;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.uniteup.dao.BlogLikesDAO;
import com.niit.uniteup.model.BlogLikes;

public class BlogLikesDAOTestCase {
	
	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static BlogLikes bloglikes;
	
	@Autowired  
	static BlogLikesDAO  blogLikesDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		bloglikes = (BlogLikes) context.getBean("bloglikes");
		blogLikesDAO = (BlogLikesDAO) context.getBean("blogLikesDAO");
	}

	@Test
	public void saveOrUpdateTestCase()
	{
		bloglikes.setBlogid(03);
		bloglikes.setLikes("04");
		bloglikes.setUserid(02);

		boolean flag = blogLikesDAO.saveOrUpdate(bloglikes);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = blogLikesDAO.delete(bloglikes);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void list()
	{
		int recordsFromDB = blogLikesDAO.list(3).size();

		assertEquals("list", 12, recordsFromDB);
	}
	
	@Test
	public void bloglistTestCase()
	{
		int recordsFromDB = blogLikesDAO.bloglist(02).size();

		assertEquals("bloglistTestCase", 12, recordsFromDB);
	}
	
	@Test
	public void listTestCase()
	{
		int recordsFromDB = blogLikesDAO.list(02).size();

		assertEquals("listTestCase", 12, recordsFromDB);
	}
}
