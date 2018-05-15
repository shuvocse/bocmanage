package com.csinfotechbd.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import com.csinfotechbd.roles.Role;

/**
 * 
 * @author Emon Hossain
 * Software Engineer,
 * Computer Source Infotech,
 * May 15, 2018 -- 12:55:02 PM,
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
@DynamicUpdate
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(length = 50, nullable = false, unique = true)
	private String username;
	@Column(length = 25, nullable = false)
	private String firstName;
	@Column(length = 25, nullable = false)
	private String lastName;
	private String password;
	private boolean active;
	
	private List<Role> roles = new ArrayList<>();

	public User(int userId) {
		this.userId = userId;
	}

	public User(String username, String firstName, String lastName, String password) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

}
