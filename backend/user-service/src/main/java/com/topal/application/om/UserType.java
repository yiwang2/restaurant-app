package com.topal.application.om;

public enum UserType {

	REGULAR("REGULAR"), OWNER("OWNER"), ADMIN("ADMIN");
	private String code;
	UserType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    } 
}
