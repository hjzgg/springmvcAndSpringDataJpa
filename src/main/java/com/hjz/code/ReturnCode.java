package com.hjz.code;

public enum ReturnCode {

	SUCCESS("success"),
	FAILURE("failure"),
	REPEAT("repeat");

	String value;

	ReturnCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
