package com.niit.uniteup.daoimpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.uniteup.dao.JobDAO;
import com.niit.uniteup.model.Job;

@Repository(value="jobDAO")
public class JobDAOImpl implements JobDAO {
	
	private static Logger log = LoggerFactory.getLogger(JobDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public JobDAOImpl(SessionFactory sessionFactory) {
		log.debug("Job Session");
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(Job job) {
		log.debug("Starting of the method saveOrUpdate job");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			log.debug("Ending of the method saveOrUpdate job");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while saveOrUpdate job");
			log.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean delete(Job job) 
	{
		log.debug("Starting of the method delete job");
		try {
			sessionFactory.getCurrentSession().delete(job);
			log.debug("Ending of the method delete job");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while deleting job");
			log.error(e.getMessage());
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Job> list(){
		log.debug("Starting of the method list job");
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Job.class);
		List<Job> list=c.list();
		log.debug("Ending of the method list job");
		return list;
	}
}