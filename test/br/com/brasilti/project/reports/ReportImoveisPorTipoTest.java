package br.com.brasilti.project.reports;

import java.util.List;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.brasilti.project.entities.Imovel;
import br.com.brasilti.project.entities.Tipo;
import br.com.wave.populator.core.Populator;
import br.com.wave.populator.exceptions.PopulatorException;

public class ReportImoveisPorTipoTest {

	private ReportImoveisPorTipo report;

	private Populator populator;

	@Before
	public void setUp() {
		WeldContainer container = new Weld().initialize();

		this.report = container.instance().select(ReportImoveisPorTipo.class).get();

		this.populator = container.instance().select(Populator.class).get();
	}

	@Test
	public void naoDeveRetornarImoveis() throws PopulatorException {
		Tipo tipo = new Tipo();
		tipo.setDescricao("Chacara");

		this.populator.populate(tipo);
		System.out.println(tipo.getId());

		List<Imovel> imoveis = this.report.gerarRelatorio(tipo);

		Assert.assertTrue(imoveis.isEmpty());
	}

	@Test
	public void deveRetornarUmImovel() throws PopulatorException {
		Tipo tipo = new Tipo();
		tipo.setDescricao("Chacara");

		this.populator.addPattern(Tipo.class, tipo);

		this.populator.populate(Imovel.class);

		List<Imovel> imoveis = this.report.gerarRelatorio(tipo);

		Assert.assertEquals(1, imoveis.size());
	}

	@After
	public void tearDown() throws PopulatorException {
		this.populator.clear();

		this.populator = null;
		this.report = null;
	}

}
