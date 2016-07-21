package recursosHumanos.entidade;

import java.util.Date;

import recursosHumanos.enumeradores.EnumSexo;
import recursosHumanos.enumeradores.EnumTipoDocumentoPessoal;
import recursosHumanos.enumeradores.EnumTipoNacionalidade;

public class Candidato {
	private String nome;
	private Date dataNascimento;
	private EnumSexo sexo;
	private EnumTipoNacionalidade nacionalidade;
	private EnumTipoDocumentoPessoal tipoDocumentoPessoal;
	private String numeroDocumentoHabilitacao;
	private String cpf;
	private String passaporte;
	private String documentoReservista;
	private Cargo cargo;


	public Candidato(){}

	public Candidato(String nome, Date dataNascimento, EnumSexo sexo, EnumTipoNacionalidade nacionalidade, EnumTipoDocumentoPessoal tipoDocumentoPessoal,
					 String numeroDocumentoHabilitacao, String cpf, String passaporte, String documentoReservista){
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
		this.tipoDocumentoPessoal = tipoDocumentoPessoal;
		this.numeroDocumentoHabilitacao = numeroDocumentoHabilitacao;
		this.cpf = cpf;
		this.passaporte = passaporte;
		this.documentoReservista = documentoReservista;
	}

	public EnumTipoDocumentoPessoal getTipoDocumentoPessoal() {

		return tipoDocumentoPessoal;
	}

	public void setTipoDocumentoPessoal(EnumTipoDocumentoPessoal tipoDocumentoPessoal) {
		this.tipoDocumentoPessoal = tipoDocumentoPessoal;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public Date getDataNascimento() {

		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public EnumTipoNacionalidade getNacionalidade() {

		return nacionalidade;
	}

	public void setNacionalidade(EnumTipoNacionalidade nacionalidade) {

		this.nacionalidade = nacionalidade;
	}

	public String getCPF() {

		return cpf;
	}

	public void setCPF(String cpf) {

		this.cpf = cpf;
	}

	public String getPassaporte() {

		return passaporte;
	}

	public void setPassaporte(String passaporte) {

		this.passaporte = passaporte;
	}

	public Cargo getCargo() {

		return cargo;
	}

	public void setCargo(Cargo cargo) {

		this.cargo = cargo;
	}

	public EnumSexo getSexo() {

		return sexo;
	}

	public void setSexo(EnumSexo sexo) {

		this.sexo = sexo;
	}

	public String getDocumentoReservista() {

		return documentoReservista;
	}

	public void setDocumentoReservista(String documentoReservista) {

		this.documentoReservista = documentoReservista;
	}

	public String getNumeroDocumentoHabilitacao() {
		return numeroDocumentoHabilitacao;
	}

	public void setNumeroDocumentoHabilitacao(String numeroDocumentoHabilitacao) {
		this.numeroDocumentoHabilitacao = numeroDocumentoHabilitacao;
	}
}
