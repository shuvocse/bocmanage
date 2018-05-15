package com.csinfotechbd.role;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.csinfotechbd.base.BaseProperty;
import com.csinfotechbd.document.DocumentEntity;
import com.csinfotechbd.user.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dms_tb_s_role")
public class RoleEntity extends BaseProperty{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private Integer roleId;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private String description;
	
	@Setter
	@Getter
	@ManyToMany(mappedBy = "roleEntities", cascade = CascadeType.DETACH)
	private List<UserEntity> userEntities = new ArrayList<>();

	@Setter
	@Getter
	@ManyToMany(mappedBy = "roleEntities", cascade = CascadeType.DETACH)
	private List<DocumentEntity> docEntities = new ArrayList<>();
	
	

	public RoleEntity() {
	}



	public RoleEntity(String name, String description, List<UserEntity> userEntities,
			List<DocumentEntity> docEntities) {
		this.name = name;
		this.description = description;
		this.userEntities = userEntities;
		this.docEntities = docEntities;
	}
	
	
	

}
