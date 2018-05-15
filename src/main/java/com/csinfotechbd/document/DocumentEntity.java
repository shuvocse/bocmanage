package com.csinfotechbd.document;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csinfotechbd.base.BaseProperty;
import com.csinfotechbd.docCategory.DocCategoryEntity;
import com.csinfotechbd.role.RoleEntity;
import com.csinfotechbd.user.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dms_tb_m_doc")
public class DocumentEntity extends BaseProperty{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private Integer docId;
	@Setter
	@Getter
	private String docName;
	@Setter
	@Getter
	private String docType;
	@Setter
	@Getter
	private String docSize;
	@Setter
	@Getter
	private long docTrackId;
	@Setter
	@Getter
	private String docUrl;
	@ManyToOne(optional = true)
	@JoinColumn(name = "ctg")
	private DocCategoryEntity docCategoryEntity;
	
	@Getter
	@Setter
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "dms_tb_j_doc_roles", joinColumns = { @JoinColumn(name = "docId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	private List<RoleEntity> roleEntities = new ArrayList<>();
	
	@Getter
	@Setter
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "dms_tb_j_doc_users", joinColumns = { @JoinColumn(name = "docId") }, inverseJoinColumns = {
			@JoinColumn(name = "userId") })
	private List<UserEntity> userEntities = new ArrayList<>();
	
	public DocumentEntity() {
	}

	public DocumentEntity(String docName, String docType, String docSize, long docTrackId, String docUrl,
			DocCategoryEntity docCategoryEntity, List<RoleEntity> roleEntities, List<UserEntity> userEntities) {
		this.docName = docName;
		this.docType = docType;
		this.docSize = docSize;
		this.docTrackId = docTrackId;
		this.docUrl = docUrl;
		this.docCategoryEntity = docCategoryEntity;
		this.roleEntities = roleEntities;
		this.userEntities = userEntities;
	}
	
	
	

}
