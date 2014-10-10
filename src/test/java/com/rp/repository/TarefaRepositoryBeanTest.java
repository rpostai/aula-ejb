package com.rp.repository;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rp.domain.Tarefa;
import com.rp.repository.interceptors.EntityInterceptor;
import com.rp.repository.jpa.TarefaRepositoryBean;
import com.rp.repository.jpa.listener.RepositoryEntityListener;

@RunWith(Arquillian.class)
public class TarefaRepositoryBeanTest {

	@EJB
	private TarefaRepository repository;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap
				.create(WebArchive.class)
				.addPackage(Tarefa.class.getPackage())
				.addPackage(TarefaRepository.class.getPackage())
				.addPackage(TarefaRepositoryBean.class.getPackage())
				.addPackage(RepositoryEntityListener.class.getPackage())
				.addPackage(EntityInterceptor.class.getPackage())
				.addClass(TarefaRepositoryBeanTest.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("test-persistence.xml","META-INF/persistence.xml")
				.addAsWebInfResource("aula-ds.xml");
	}

	@Test
	public void testInsertTarefa() {
		Tarefa t = new Tarefa();
		t.setDescricaoResumida("Primeira tarefa");
		repository.salvar(t);
		Assert.assertNotNull(t.getDataCadastro());
		Assert.assertNotNull(t.getId());
	}

	@Test
	@UsingDataSet("tarefa.xml")
	@ShouldMatchDataSet("tarefas-esperadas.xml")
	public void getTodasTarefas() {
		List<Tarefa> tarefas = repository.getTodos();
		Assert.assertEquals(2, tarefas.size());
	}

}
