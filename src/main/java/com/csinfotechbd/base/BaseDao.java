package com.csinfotechbd.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csinfotechbd.user.User;
import com.csinfotechbd.user.User_;

/**
 * 
 * @author Emon Hossain Software Engineer, Computer Source Infotech, May 15,
 *         2018 -- 3:58:28 PM,
 */
@Repository
@Transactional
public class BaseDao {

	@Autowired
	private EntityManager entityManager;

	public List<User> findAllUser() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		List<User> users = entityManager.createQuery(query).getResultList();
		return users;
	}

	public User findById(long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		query.where(builder.equal(root.get(User_.id), id));
		User user = entityManager.createQuery(query).getSingleResult();
		return user;
	}

	public void saveUser(User user) {
		entityManager.persist(user);
	}

	public void updateUser(User user) {
		User u = entityManager.find(User.class, user.getUserId());
		u.setFirstName("ABC");
		entityManager.flush();
	}

	public void deleteUser(User user) {
		entityManager.remove(user);
	}
}
