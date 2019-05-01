package com.restservice.example.springbootrestexample.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All about Users")
public class User {
	private Integer id;
	
	@ApiModelProperty(notes="Name should have at least 2 characters")
	@Size(min=2,message="Name should have at least 2 characters")
	private String name;
	
	@ApiModelProperty(notes="Bith Date cannot be in past")
	@Past
	private Date birthDate;
	
	
	public User() {
		super();
	}


	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}