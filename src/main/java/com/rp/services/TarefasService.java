package com.rp.services;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rp.domain.Tarefa;
import com.rp.repository.TarefaRepository;

@Stateless
public class TarefasService {

	@EJB
	private TarefaRepository repository;

	@Asynchronous
	public Future<Integer> calculaTempoEspera(Tarefa t) {
		return new AsyncResult<Integer>(t.getTempoEsperaEmDias());
	}
}
