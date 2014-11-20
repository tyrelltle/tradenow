package com.tradenow.domains.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tradenow.domains.IEntity;


@Entity
@Table(name = "user_roles")
public class UserRole implements IEntity{
	public static enum ROLES{
		ROLE_USER
	}
	private Integer userRoleId;
	private User user;
	private String role;
 
	public UserRole() {
	}
 
	public UserRole(ROLES r){
		this.role=r.name();
	}
	public UserRole(User user, ROLES r){
		this.user=user;
		this.role=r.name();
	}
	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}
 


	@Id
	@GeneratedValue
	@Column(name = "user_role_id", 
		unique = true, nullable = false)
	public Integer getUserRoleId() {
		return this.userRoleId;
	}
 
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public User getUser() {
		return this.user;
	}
 
	public void setUser(User user) {
		this.user = user;
	}
 
	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}
 
	public void setRole(String role) {
		this.role = role;
	}
}