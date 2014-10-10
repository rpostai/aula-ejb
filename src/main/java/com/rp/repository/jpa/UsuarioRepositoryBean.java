package com.rp.repository.jpa;

import javax.ejb.Stateless;

import com.rp.domain.Usuario;
import com.rp.repository.UsuarioRepository;

@Stateless
public class UsuarioRepositoryBean extends BaseRepository<Usuario> implements
		UsuarioRepository {

	public UsuarioRepositoryBean() {
		super(Usuario.class);
	}

}
