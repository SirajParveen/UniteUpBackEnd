package com.niit.uniteup;

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
		
	}
	
	@Test
	public void deleteTestCase()
	{
		
	}
	
	@Test
	public void getTestCase()
	{
		
	}
	
	@Test
	public void listTestCase()
	{
		
	}
	
	@Test
	public void userlistTestCase()
	{
		
	}
}
