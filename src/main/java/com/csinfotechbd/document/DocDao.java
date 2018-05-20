package com.csinfotechbd.document;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DocDao {

	@Autowired
	private EntityManager entityManager;
	
	public void saveToDb(Document document) {
		entityManager.persist(document);
	}

	public Document findFileByFileId(long fileId) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Document> query = builder.createQuery(Document.class);
		Root<Document> root = query.from(Document.class);
		query.where(builder.equal(root.get("docId"), fileId));		
		Document doc = entityManager.createQuery(query).getSingleResult();
		return doc;
	}

}
