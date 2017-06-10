package com.niit.uniteup;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.uniteup.dao.JobDAO;
import com.niit.uniteup.model.Job;

public class JobDAOTestCase {

	@Autowired  
	static AnnotationConfigApplicationContext context;
	
	@Autowired  
	static Job job;
	
	@Autowired  
	static JobDAO  jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		job = (Job) context.getBean("job");
		jobDAO = (JobDAO) context.getBean("jobDAO");
	}
	
	@Test
	public void saveOrUpdateTestCase()
	{
		job.setCompany("wipro");
		/*job.setDoc(03-03-2017);*/
		job.setJobdetails("software");
		/*job.setLastdate(03-03-2017);*/
		job.setTitle("job");
		job.setUserid(03);

		boolean flag = jobDAO.saveOrUpdate(job);
		
		assertEquals("saveOrUpdateTestCase", true, flag);
	}
	
	@Test
	public void deleteTestCase()
	{
		boolean flag = jobDAO.delete(job);
		
		assertEquals("deleteTestCase", true, flag);
	}
	
	@Test
	public void listTestCase()
	{
		int recordsFromDB = jobDAO.list().size();

		assertEquals("listTestCase", 12, recordsFromDB);
	}
}
