package com.rp.repository.interceptors;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rp.domain.BaseEntity;
import com.rp.domain.Log;
import com.rp.repository.LogRepository;

public class EntityInterceptor {

	@EJB
	private LogRepository logRepository;

	@AroundInvoke
	public Object salvarLog(InvocationContext context)
			throws java.lang.Exception {
		Object[] params = context.getParameters();
		Object result;
		try {
			result = context.proceed();
		} finally {
			if (params != null && params.length > 0) {
				BaseEntity entity = (BaseEntity) params[0];
				Log log = new Log();
				log.setObjeto(entity.toString());
				logRepository.salvar(log);
			}
		}
		return result;
	}

}
