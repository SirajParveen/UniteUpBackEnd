
package com.niit.uniteup.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.uniteup.dao.UsersDAO;
import com.niit.uniteup.model.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	private static Logger log = LoggerFactory.getLogger(UsersDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public UsersDAOImpl(SessionFactory sessionFactory) {
		log.debug("Users Session");
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Users users) {
		log.debug("Starting of the method saveOrUpdate users");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(users);
			log.debug("Ending of the method saveOrUpdate users");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while saveOrUpdate users");
			log.error(e.getMessage());
			return false;
		}
	}

	@Transactional
	public boolean delete(Users users) {
		log.debug("Starting of the method delete users");
		try {
			sessionFactory.getCurrentSession().delete(users);
			log.debug("Ending of the method delete users");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occurred while deleting users");
			log.error(e.getMessage());
			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Users> list() {
		log.debug("Starting of the method list users");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Users.class);
		List<Users> list = c.list();
		log.debug("Ending of the method list users");
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<Users> getuser(int id) {
		log.debug("Starting of the method getuser");
		String hql = "from Users where id= " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> list = query.list();

		if (list == null) {
			log.debug("getuser is null");
			return null;
		} else {
			log.debug("List of the users");
			return list;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Users authuser(String username, String password) {
		log.debug("Starting of the method getuser");
		String hql = "from Users where username= " + "'" + username + "'" + "and password= " + "'" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> list = query.list();
		if (list.isEmpty()) {
			log.debug("authuser is null");
			return null;
		} else {
			log.debug("List of the users");
			return list.get(0);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Users oneuser(int id) {
		log.debug("Starting of the method oneuser");
		String hql = "from Users where id= " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> list = query.list();
		if (list.isEmpty()) {
			log.debug("oneuser is null");
			return null;
		} else {
			log.debug("List of the users");
			return list.get(0);
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Users> nonfriends(int id, String username) {
		log.debug("Starting of the method nonfriends");
		String hql = "from Users where id !='" + id + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> list = query.list();
		log.debug("Ending of the method nonfriends");
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public Users profileof(String username) {
		log.debug("Starting of the method profileof");
		String hql = "from Users where username='" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> list = query.list();
		if (list.isEmpty()) {
			log.debug("profileof is null");
			return null;
		} else {
			log.debug(" list of profileof");
			return list.get(0);
		}
	}
}
