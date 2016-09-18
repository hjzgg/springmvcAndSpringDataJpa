package com.hjz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity extends AbsIdEntity implements Serializable{

	private static final long serialVersionUID = -1649223236097252346L;
	
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
