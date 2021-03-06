package recursosHumanos.entidade;

import recursosHumanos.enumeradores.EnumTipoDocumentoHabilitacao;

import java.util.ArrayList;
import java.util.Collection;

public class Cargo {
	private String descricao;
	private double salario;
	private EnumTipoDocumentoHabilitacao tipoDocumentoHabilitacao;

	private int quantidadeVagas;

	public Cargo(){};
	
	public Cargo(String desc, double sal, EnumTipoDocumentoHabilitacao tpDocHab, int qtdeVagas){
		this.descricao = desc;
		this.salario = sal;
		this.tipoDocumentoHabilitacao = tpDocHab;
		this.quantidadeVagas = qtdeVagas;
	}
	
	public String getDescricao() {

		return descricao;
	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	public double getSalario() {

		return salario;
	}

	public void setSalario(double salario) {

		this.salario = salario;
	}

	public EnumTipoDocumentoHabilitacao getTipoDocumentoHabilitacao() {

		return tipoDocumentoHabilitacao;
	}

	public void setTipoDocumentoHabilitacao(EnumTipoDocumentoHabilitacao tipoDocumentoHabilitacao) {
		this.tipoDocumentoHabilitacao = tipoDocumentoHabilitacao;
	}

	public int getQuantidadeVagas() {

		return quantidadeVagas;

	}

	public void setQuantidadeVagas(int quantidadeVagas) {

		this.quantidadeVagas = quantidadeVagas;
	}

}
