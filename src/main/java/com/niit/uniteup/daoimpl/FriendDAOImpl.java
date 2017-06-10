package com.niit.uniteup.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.uniteup.dao.FriendDAO;
import com.niit.uniteup.model.Friend;

@SuppressWarnings("deprecation")
@Repository(value="friendDAO")
public class FriendDAOImpl implements FriendDAO {
	
	private static Logger log = LoggerFactory.getLogger(FriendDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public FriendDAOImpl(SessionFactory sessionFactory){
		log.debug("Friend Session");
		this.sessionFactory=sessionFactory;
	}
	
   @Transactional
	public boolean saveOrUpdate(Friend friend) {
	   log.debug("Starting of the method saveOrUpdate friend");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			log.debug("Ending of the method saveOrUpdate friend");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while saveOrUpdate friend");
			log.error(e.getMessage());
			return false;
		}
	}

   @Transactional
	public boolean delete(Friend friend) {
	   log.debug("Starting of the method delete friend");
		try {
			sessionFactory.getCurrentSession().delete(friend);
			log.debug("Ending of the method delete friend");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error("Exception occurred while deleting friend");
			log.error(e.getMessage());
			return false;
		}
	}


@SuppressWarnings({ "rawtypes", "unchecked" })
@Transactional
public Friend newrequest(String uid,String fid) {
	log.debug("Starting of the method newrequest");
	String hql="from Friend where userid='"+uid+"' and friendid='"+fid+"'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list=query.list();
	if(list==null){
		log.debug("newrequest is null");
		return null;
	}else{
		log.debug("List of the newrequest");
		return list.get(0);
	}
}

@Transactional
public List<Friend> getfriendlist(String uid) {
	log.debug("Starting of the method getfriendlist");
	String hql="from Friend where userid='"+uid+"' and status='A'";
	@SuppressWarnings("rawtypes")
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> list = query.list();
	log.debug("Ending of the method getfriendlist");
	return list;
}

@Transactional
public List<Friend> getrequestlist(String uid) {
	log.debug("Starting of the method getrequestlist");
	String hql="from Friend where friendid='"+uid+"' and status='N'";
	@SuppressWarnings("rawtypes")
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> list = query.list();
	log.debug("Ending of the method getrequestlist");
	return list;
}

@Transactional
public List<Friend> setonline(String uid) {
	log.debug("Starting of the method setonline");
	String hql="from Friend where friendid='"+uid+"'";
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> list=query.list();
	log.debug("Ending of the method setonline");
	return list;
	}
}
