package com.niit.uniteup.daoimpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.uniteup.dao.ForumDAO;
import com.niit.uniteup.model.Forum;

@SuppressWarnings("deprecation")
@Repository(value="forumDAO")
public class ForumDAOImpl implements ForumDAO {
	
	private static Logger log = LoggerFactory.getLogger(ForumDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory) {
		log.debug("Forum Session");
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Forum forum) {
		log.debug("Starting of the method saveOrUpdate forum");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			log.debug("Ending of the method saveOrUpdate forum");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while saveOrUpdate forum");
			log.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean delete(Forum forum) {
		log.debug("Starting of the method delete forum");
		try {
			sessionFactory.getCurrentSession().delete(forum);
			log.debug("Ending of the method delete forum");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while deleting forum");
			log.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public List<Forum> list() {
		log.debug("Starting of the method list forum");
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Forum.class);
		@SuppressWarnings("unchecked")
		List<Forum> list=c.list();
		log.debug("Ending of the method listBlog");
		return list;
	}
@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Forum getforum(int id) {
	log.debug("Starting of the method getforum");
		String hql = "from Forum where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum>list= query.list();
		
		if(list==null)
		{
			log.debug("getforum is null");
			return null;
		}
		else
		{
			log.debug("List of the forum");
			return list.get(0);
		}
	}
@Transactional
public List<Forum> userlist() {
	log.debug("Starting of the method userlist");
	String hql= "from Forum where status='a'";
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Forum> list=query.list();
	if(list==null){
		log.debug("userlist is null");
	return null;
	}
	else{
		log.debug("List of the user");
		return list;
	}
}

@Transactional
public Forum get(int id) {
	log.debug("Starting of the method get forum");
	String hql = "from Forum where id='"+ id+"'" ;
	@SuppressWarnings("rawtypes")
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Forum>list= query.list();
	
	if(list==null)
	{
		log.debug("getforum is null");
		return null;
	}
	else
	{
		log.debug("List of the forum");
		return list.get(0);
	}
}
}
