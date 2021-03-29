package com.topal.om.utils;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.topal.om.constants.IdentifierConstant;


public class RandomStringIdGenerator implements IdentifierGenerator {

	public String generateStringId() {
		return UUID.randomUUID().toString().substring(0,IdentifierConstant.identifierLength);
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return this.generateStringId();
	}

}
