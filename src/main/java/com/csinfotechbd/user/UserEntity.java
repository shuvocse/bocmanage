package com.csinfotechbd.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.csinfotechbd.base.BaseProperty;
import com.csinfotechbd.role.RoleEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dms_tb_s_user")
public class UserEntity extends BaseProperty{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private Integer userId;
	@Setter
	@Getter
	private String username;
	@Setter
	@Getter
	private String password;
	@Transient
	@Setter
	@Getter
	private String confirmPassword;
	@Setter
	@Getter
	private String fullName;
	@Setter
	@Getter
	private String email;
	@ManyToMany(/*cascade = CascadeType.DETACH,*/ fetch = FetchType.LAZY)
	@JoinTable(name = "dms_tb_j_users_roles", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	@Setter
	@Getter
	private List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();

}
