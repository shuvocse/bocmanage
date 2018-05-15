package com.csinfotechbd.docCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.csinfotechbd.base.BaseProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dms_tb_s_ctg")
public class DocCategoryEntity extends BaseProperty{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private Integer ctgId;
	@Setter
	@Getter
	private String ctgName;
	public DocCategoryEntity(Integer ctgId, String ctgName) {
		this.ctgId = ctgId;
		this.ctgName = ctgName;
	}
	public DocCategoryEntity() {
	}
	
	

}
