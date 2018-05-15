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

import com.csinfotechbd.users.User;
import com.csinfotechbd.users.User_;

/**
 * 
 * @author Emon Hossain Software Engineer, Computer Source Infotech, May 15,
 *         2018 -- 3:58:28 PM,
 */
@Repository
@Transactional
public class BaseDao {

	
}
