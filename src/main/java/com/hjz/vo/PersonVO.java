package com.hjz.vo;

import java.io.Serializable;

public class PersonVO extends SuperVO implements Serializable{

	private static final long serialVersionUID = -4745138914786180462L;
	private String name;
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
