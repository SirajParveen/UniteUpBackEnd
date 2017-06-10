package com.niit.uniteup;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;

import com.niit.uniteup.dao.EventDAO;
import com.niit.uniteup.model.Event;

public class EventDAOTestCase {

	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static Event event;
	
	@Autowired  
	static EventDAO  eventDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		event = (Event) context.getBean("event");
		eventDAO = (EventDAO) context.getBean("eventDAO");
	}
	
	@Test
	public void saveOrUpdateTestCase()
	{
		event.setDescription("event");
		/*event.setDoe(02-03-2017);*/
		event.setName("event");
		event.setTopic("event");
		event.setUserid("03");

		boolean flag = eventDAO.saveOrUpdate(event);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = eventDAO.delete(event);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void getTestCase()
	{
		event = (Event) eventDAO.get(02);
		
		assertEquals("getuserTestCase", null, event);
	}
	
	@Test
	public void listTestCase()
	{
		int recordsFromDB = eventDAO.list().size();

		assertEquals("listTestCase", 12, recordsFromDB);
	}
}
