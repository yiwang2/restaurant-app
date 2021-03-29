package com.topal.om.user;

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
