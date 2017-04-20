package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@SuppressWarnings("deprecation")
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;

	public User get(String id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	//If Spring sec is not used
	public boolean isValidCredentials(String id, String password) {
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery("from User where id=? and password=? ");
		query.setString(0, id);
		query.setString(1, password);
		
		if(query.uniqueResult() == null)
		{
			return false;
		}
		else{
			return true;
		}
	}

	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
