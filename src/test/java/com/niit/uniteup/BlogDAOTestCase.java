package com.niit.uniteup;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.uniteup.dao.BlogDAO;
import com.niit.uniteup.model.Blog;

public class BlogDAOTestCase {

	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static Blog blog;
	
	@Autowired  
	static BlogDAO  blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		blog = (Blog) context.getBean("blog");
		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}
	
	@Test
	public void saveOrUpdateTestCase()
	{
		blog.setBloglike(1);
		blog.setContent("blog");
		/*blog.setDoc(02-03-2017);*/
		/*blog.setStatus(status);*/
		blog.setTitle("blog");
		blog.setUserid(01);

		boolean flag = blogDAO.saveOrUpdate(blog);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = blogDAO.delete(blog);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void getTestCase()
	{
		blog = blogDAO.get(02);
		
		assertEquals("getTestCase", null, blog);
	}
	
	@Test
	public void listTestCase()
	{
		int recordsFromDB = blogDAO.list().size();

		assertEquals("listTestCase", 12, recordsFromDB);
	}
	
	@Test
	public void userlistTestCase()
	{
		int recordsFromDB = blogDAO.userlist().size();

		assertEquals("userlistTestCase", 12, recordsFromDB);
	}
}
