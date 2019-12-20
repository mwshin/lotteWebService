package com.lotteproject.webservice.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) // auto created ID
	private Long id;
	@Column(length=100, nullable=false) // varchar(100) not null
	private String name;
	@Column		// varchar(255) 
	private String hobby;
	@Column 
	private Date createDate;
	
	public User(){}
	
	public User(String name, String hobby){
		this.name = name;
		this.hobby = hobby;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@PrePersist // auto created date when it's created
	public void prePersis(){
		createDate = new Date();
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
