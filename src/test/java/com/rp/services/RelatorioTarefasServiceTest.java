package com.rp.services;

import java.util.concurrent.Future;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rp.domain.Tarefa;
import com.rp.repository.TarefaRepository;
import com.rp.repository.TarefaRepositoryBeanTest;
import com.rp.repository.interceptors.EntityInterceptor;
import com.rp.repository.jpa.TarefaRepositoryBean;
import com.rp.repository.jpa.listener.RepositoryEntityListener;

@RunWith(Arquillian.class)
public class RelatorioTarefasServiceTest {

	@EJB
	private RelatorioTarefasService service;

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
				.addPackage(TarefasService.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource("aula-ds.xml");
	}

	@Test
	@UsingDataSet("tarefa.xml")
	public void testRelatorioTarefas() throws Exception {
		Future<String> result = service.gerarRelatorioTempoEspera();
		Assert.assertEquals("34", result.get());
	}
}
