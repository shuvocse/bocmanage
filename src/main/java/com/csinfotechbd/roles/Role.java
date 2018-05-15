package com.csinfotechbd.roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.csinfotechbd.users.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "dms_tb_s_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private Integer roleId;
	@Setter
	@Getter
	private String role;
	@Setter
	@Getter
	private String description;
	
	@Setter
	@Getter
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.DETACH)
	private List<UserEntity> users = new ArrayList<>();
}
