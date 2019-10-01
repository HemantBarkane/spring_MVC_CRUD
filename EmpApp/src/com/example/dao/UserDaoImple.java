package com.example.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.example.dto.User;

@Repository
public class UserDaoImple implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public boolean add(final User user) {
		boolean flag = false;
		hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.save(user);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		flag = true;
		return flag;
	}

	public boolean remove(final int userId) {
		boolean flag = false;
		hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.delete(new User(userId));
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		flag = true;
		return flag;
	}

	public boolean update(final User user) {
		boolean flag = false;
		hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				session.update(user);
				t.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		flag = true;
		return flag;
	}

	public List<User> selectAll() {
		
		List<User> ulist = hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from User");
				List<User> li = q.list();
				t.commit();
				session.close();
				return li;
			}
		});
		
		return ulist;
	}

	public User selectById(final int userId) {
		User u = hibernateTemplate.execute(new HibernateCallback<User>() {

			public User doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				User user = (User)session.get(User.class, userId);
				t.commit();
				session.close();
				return user;
			}
		});
		
		return u;
	}
	
	public boolean login(User user) {
		
		List<User> ulist = hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction t = session.beginTransaction();
				Query q = session.createQuery("from User where userName = ? and userPass =?");
				q.setString(0, user.getUserName());
				q.setString(1, user.getUserPass());
				List<User> li = q.list();
				t.commit();
				session.close();
				return li;
			}
		});
		
		return !ulist.isEmpty();
	}

}
