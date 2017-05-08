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

import com.niit.uniteup.dao.BlogDAO;
import com.niit.uniteup.model.Blog;

@SuppressWarnings("deprecation")
@Repository(value="blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	private static Logger log = LoggerFactory.getLogger(UsersDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public BlogDAOImpl(SessionFactory sessionFactory) {
		log.debug("Blog Session");
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean saveOrUpdate(Blog blog) {
	log.debug("Starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			log.debug("Ending of the method saveOrUpdate");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while creating user");
			log.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean delete(Blog blog) {
		log.debug("Starting of the method deleteBlog");
		try {
			sessionFactory.getCurrentSession().delete(blog);
			log.debug("Ending of the method deleteBlog");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while creating user");
			log.error(e.getMessage());
			return false;
		}
	}
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Blog> list() {
		log.debug("Starting of the method listBlog");
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		List<Blog> list=c.list();
		log.debug("Ending of the method listBlog");
		return list;
	}
	
	@Transactional
	public Blog get(int id) {
		log.debug("Starting of the method getBlog");
		String hql = "from Blog where id='"+ id+"'" ;
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog>list= query.list();
		
		if(list==null)
		{
			log.debug("getBlog is null");
			return null;
		}
		else
		{
			log.debug("List of the blog");
			return list.get(0);
		}
	}
	@Transactional
	public List<Blog> userlist() {
		log.debug("Starting of the method getBlog");
		String hql= "from Blog where status='a'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list=query.list();
		if(list==null){
			log.debug("list of blog is null");
		return null;
		}
		else{
			log.debug("list of the user");
			return list;
		
		}
	}

}
