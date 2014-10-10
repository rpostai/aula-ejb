package com.rp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rp.repository.jpa.listener.RepositoryEntityListener;

@Entity
@Table(name = "al_tarefa")
@EntityListeners({ RepositoryEntityListener.class })
public class Tarefa extends BaseEntity {

	@Column(name = "descricao_resumida", length = 100, nullable = false)
	private String descricaoResumida;

	@Column(name = "descricao_detalhada", nullable = true)
	@Lob
	private String descricaoDetalhda;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrevista;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRealizada;

	public String getDescricaoResumida() {
		return descricaoResumida;
	}

	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}

	public String getDescricaoDetalhda() {
		return descricaoDetalhda;
	}

	public void setDescricaoDetalhda(String descricaoDetalhda) {
		this.descricaoDetalhda = descricaoDetalhda;
	}

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Date getDataRealizada() {
		return dataRealizada;
	}

	public void setDataRealizada(Date dataRealizada) {
		this.dataRealizada = dataRealizada;
	}

	@Override
	public String toString() {
		return "Tarefa [descricaoResumida=" + descricaoResumida
				+ ", descricaoDetalhda=" + descricaoDetalhda
				+ ", dataPrevista=" + dataPrevista + ", dataRealizada="
				+ dataRealizada + "]";
	}
	
	

}
