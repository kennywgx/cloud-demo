package com.kenny.shirodemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transactional;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3707336013186284296L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@ManyToMany(targetEntity = Role.class, mappedBy = "users")
	private List<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	@Transactional
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
}
