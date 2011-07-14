package br.com.brasilti.project.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
public class Imovel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private Integer version;

	private Boolean active;

	private String localizacao;

	private Integer qtdeDeQuartos;

	private BigDecimal area;

	private BigDecimal valor;

	@ManyToOne
	private Tipo tipo;

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Imovel imovel = (Imovel) obj;
		return new EqualsBuilder().append(this.localizacao, imovel.localizacao).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.localizacao).toHashCode();
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Integer getQtdeDeQuartos() {
		return qtdeDeQuartos;
	}

	public void setQtdeDeQuartos(Integer qtdeDeQuartos) {
		this.qtdeDeQuartos = qtdeDeQuartos;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public Boolean getActive() {
		return active;
	}

}
