package com.niit.uniteup.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.uniteup.dao.BlogLikesDAO;
import com.niit.uniteup.model.BlogLikes;

@SuppressWarnings("deprecation")
@Repository("blogLikesDAO")
public class BlogLikesDAOImpl implements BlogLikesDAO {
	
	private static Logger log = LoggerFactory.getLogger(BlogLikesDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogLikesDAOImpl(SessionFactory sessionFactory) {
		log.debug("BlogLikes Session");
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean saveOrUpdate(BlogLikes blogLikes) {
		log.debug("Starting of the method saveOrUpdate BlogLikes");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogLikes);
			log.debug("Ending of the method saveOrUpdate BlogLikes");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while saveOrUpdate BlogLikes");
			log.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean delete(BlogLikes blogLikes) {
		log.debug("Starting of the method delete BlogLikes");
		try {
			sessionFactory.getCurrentSession().delete(blogLikes);
			log.debug("Ending of the method delete BlogLikes");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while deleting BlogLikes");
			log.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public BlogLikes list(int uid, int bid) {
		log.debug("Starting of the method list BlogLikes");
		String hql="from Bloglikes where blogid='"+bid+"' and userid='"+uid+"'";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
@SuppressWarnings("unchecked")
List<BlogLikes>list= query.list();
		
		if(list==null)
		{
			log.debug("list BlogLikes is null");
			return null;
		}
		else
		{
			log.debug("List of the bloglikes");
			return list.get(0);
		}	
	}

	@Transactional
	public List<BlogLikes> bloglist(int bid) {
		log.debug("Starting of the method BlogLikes bloglist");
		Criteria c=sessionFactory.getCurrentSession().createCriteria(BlogLikes.class);
		c.add(Restrictions.eq("blogid",bid));
		@SuppressWarnings("unchecked")
		List<BlogLikes> list=c.list();
		log.debug("Ending of the method BlogLikes bloglist");
        return list;
	}
	@Transactional
	public List<BlogLikes> list(int uid) {
		log.debug("Starting of the method BlogLikes list");
		//Criteria c=sessionFactory.getCurrentSession().createCriteria(BlogLikes.class);
		String hql = "from BlogLikes where userid ="+uid;
		@SuppressWarnings("unchecked")
		List<BlogLikes> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		log.debug("Ending of the method BlogLikes list");
		return list;
	}
}