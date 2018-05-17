package com.csinfotechbd.document;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DocDao {

	@Autowired
	private EntityManager entityManager;
	
	public void saveToDb(Document document) {
		entityManager.persist(document);
	}

}
