package com.rp.repository.jpa;

import javax.ejb.Stateless;

import com.rp.domain.Tarefa;
import com.rp.repository.TarefaRepository;

@Stateless
public class TarefaRepositoryBean extends BaseRepository<Tarefa> implements
		TarefaRepository {

	public TarefaRepositoryBean() {
		super(Tarefa.class);
	}

}
