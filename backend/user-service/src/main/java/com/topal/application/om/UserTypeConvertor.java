package com.topal.application.om;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class UserTypeConvertor implements AttributeConverter<UserType, String>{

	@Override
	public String convertToDatabaseColumn(UserType userType) {
		if (userType == null) {
            return null;
        }
        return userType.getCode();
	}

	@Override
	public UserType convertToEntityAttribute(String userTypeCode) {
		if (userTypeCode == null) {
            return null;
        }

        return Stream.of(UserType.values())
          .filter(c -> c.getCode().equals(userTypeCode))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
	}

}
