package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="boot_user")
public class User implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -6550777752269466791L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String name;
	
	private String loginName;
	
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdate;
	
	@ManyToOne
	@JoinColumn(name = "did")
	@JsonBackReference
	private Department department;
	
	@ManyToMany(cascade={},fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
		joinColumns={@JoinColumn(name="user_id")},
		inverseJoinColumns = {@JoinColumn(name="roles_id")})
	private List<Role> roleList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String loginName, String password,
			Date createdate, Department department, List<Role> roleList) {
		super();
		this.id = id;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.createdate = createdate;
		this.department = department;
		this.roleList = roleList;
	}

	
}
