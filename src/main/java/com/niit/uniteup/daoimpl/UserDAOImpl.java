package com.niit.uniteup.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.uniteup.dao.UserDAO;
import com.niit.uniteup.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(User User) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(User);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(User User) {
		try {
			sessionFactory.getCurrentSession().delete(User);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<User> list() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> list = c.list();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<User> getuser(int id) {
		String hql = "from User where id= " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();

		if (list == null) {
			return null;
		} else {
			return list;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public User authuser(String username, String password) {
		String hql = "from User where username= " + "'" + username + "'" + "and password= " + "'" + password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		if (list.isEmpty()) {
			return null;	
			}
		else {
			return list.get(0);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public User oneuser(int id) {
		String hql = "from User where id= " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		List<User> list = query.list();

		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<User> nonfriends(int id) {
		String hql = "from User where id !='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public User profileof(String username) {
		String hql = "from User where username='" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();

		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
