package br.com.brasilti.project.reports;

import java.util.List;

import javax.inject.Inject;

import br.com.brasilti.project.entities.Imovel;
import br.com.brasilti.project.entities.Tipo;
import br.com.brasilti.repository.core.Seeker;
import br.com.brasilti.repository.propositions.Equals;

public class ReportImoveisPorTipo {

	@Inject
	private Seeker seeker;

	public List<Imovel> gerarRelatorio(Tipo tipo) {
		this.seeker.giveme(Imovel.class);
		this.seeker.whose(new Equals("tipo", tipo));

		return this.seeker.go();
	}

}
