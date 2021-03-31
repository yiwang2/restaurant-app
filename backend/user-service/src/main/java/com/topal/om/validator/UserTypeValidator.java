package com.topal.om.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.topal.application.om.UserType;

public class UserTypeValidator implements ConstraintValidator<UserTypeSubset, UserType>{

	private UserType[] subset;
	
	@Override
    public void initialize(UserTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(UserType value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }

}
