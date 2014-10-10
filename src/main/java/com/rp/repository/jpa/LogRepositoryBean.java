package com.rp.repository.jpa;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.ExcludeDefaultInterceptors;

import com.rp.domain.Log;
import com.rp.repository.LogRepository;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LogRepositoryBean extends BaseRepository<Log> implements
		LogRepository {
	public LogRepositoryBean() {
		super(Log.class);
	}

	@Override
	@ExcludeDefaultInterceptors
	public void salvar(Log obj) {
		super.salvar(obj);
	}
}
