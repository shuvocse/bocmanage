package com.csinfotechbd.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Emon Hossain on 8/24/2017.
 */
@Repository
@Transactional
public class BlogDao {

    @Autowired
    private EntityManager manager;

    private Session getSession() {
        return this.manager.unwrap(Session.class);
    }

    @SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<?> clazz) {
        return getSession().createCriteria(clazz).list();
    }

    public <T> Object findById(Class<?> clazz, T id) {
        return getSession().createCriteria(clazz).add(Restrictions.idEq(id)).uniqueResult();
    }

    public <T> void saveEntity(String entityName, Object obj) {
        getSession().save(entityName, obj);
    }

    public <T> void updateEntity(String entityName, Object obj) {
        getSession().update(entityName, obj);
    }

    public <T> void deleteEntity(T entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
	public <T> List<T> findByPropertyName(Class<T> clazz, String propertyName, T value) {
		return getSession().createCriteria(clazz).add(Restrictions.eq(propertyName, value)).list();
    }

    public <T> Object findByUniquePropertyName(Class<T> clazz, String propertyName, T value) {
        return getSession().createCriteria(clazz).add(Restrictions.eq(propertyName, value)).uniqueResult();
    }
}
