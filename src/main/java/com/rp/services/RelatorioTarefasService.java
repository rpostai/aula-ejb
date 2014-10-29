package com.rp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rp.domain.Tarefa;
import com.rp.repository.TarefaRepository;

@Stateless
public class RelatorioTarefasService {

	@EJB
	private TarefaRepository repository;

	@EJB
	private TarefasService service;

	@Asynchronous
	public Future<String> gerarRelatorioTempoEspera() throws Exception {
		List<Tarefa> tarefas = repository.getTodos();
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for (Tarefa t : tarefas) {
			results.add(service.calculaTempoEspera(t));
		}

		StringBuilder sb = new StringBuilder();
		for (Future<Integer> f : results) {
			sb.append(Integer.toString(f.get()));
		}
		
		return new AsyncResult<String>(sb.toString());
	}

}
