package com.rp.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="al_tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="descricao_resumida", length=100, nullable=false)
	private String descricaoResumida;

	@Column(name="descricao_detalhada", nullable=true)
	@Lob
	private String descricaoDetalhda;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro", nullable=false)
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrevista;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRealizada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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
	
	@PrePersist
	public void setDataCadastro() {
		Calendar c = Calendar.getInstance();
		this.setDataCadastro(c.getTime());
	}

}
