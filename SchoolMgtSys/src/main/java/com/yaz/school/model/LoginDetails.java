package com.yaz.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="sch_t_login_details")
public class LoginDetails {
	
	@Id
	@SequenceGenerator(name="pk_login_details_id",sequenceName="seq_login_details_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_login_details_id" )
	@Column(name = "login_id", unique = true, nullable = false)
	private Long loginId;
	
	@Column(name="user_role")
	private String userRole;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
