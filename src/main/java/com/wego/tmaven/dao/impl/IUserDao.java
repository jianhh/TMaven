package com.wego.tmaven.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wego.tmaven.dao.UserDao;
import com.wego.tmaven.entity.User;

@Repository("userDao")
public class IUserDao implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private HibernateTemplate hibernateTemplate;
	
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	private HibernateTemplate getHibernateTemplate(){
		if(hibernateTemplate==null){
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
		return hibernateTemplate;
	}

	@Override
	public User load(String id) {
		return (User) this.getCurrentSession().load(User.class, id);
	}

	@Override
	public User get(String id) {
		return (User) this.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return this.getCurrentSession().createQuery("from user").setCacheable(true).list();
	}

	@Override
	public void persist(User entity) {
		this.getCurrentSession().persist(entity);
	}

	@Override
	public String save(User entity) {
		return (String) getHibernateTemplate().save(entity);
	}

	@Override
	public void saveOrUpdate(User entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(String id) {
		this.getCurrentSession().delete(id);
	}

	@Override
	public void flush() {
		this.getCurrentSession().flush();
	}

}
