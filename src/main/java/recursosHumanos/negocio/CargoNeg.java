package recursosHumanos.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import recursosHumanos.entidade.Candidato;
import recursosHumanos.entidade.Cargo;
import recursosHumanos.excecoes.*;
import recursosHumanos.util.Mensagem;
import recursosHumanos.enumeradores.EnumTipoDocumentoHabilitacao;

public class CargoNeg {
	
	private boolean result = false;
	private final String engenheiro = "Engenheiro";
	private final String medico = "Médico";
	private final String tecnicoInformatica = "Técnico em Informática";
	private final String motorista = "Motorista";

	private List<String> obtemListaDescricoesValidas(){
		List<String> cargos = new ArrayList<String>();
		cargos.add(engenheiro);
		cargos.add(medico);
		cargos.add(tecnicoInformatica);
		cargos.add(motorista);
		return cargos;
	}

	private int obtemQuantidadeVagasIncialCargo(Cargo cargo) throws CargoInvalidoException{
		int quantidadeVagas = 0;
		if(cargo.getDescricao() != null){
			if(cargo.getDescricao().equals(engenheiro)){
				quantidadeVagas = 50;
			}else if(cargo.getDescricao().equals(medico)){
				quantidadeVagas = 10;
			}else if(cargo.getDescricao().equals(motorista)){
				quantidadeVagas = 15;
			}else if(cargo.getDescricao().equals(tecnicoInformatica)){
				quantidadeVagas = 20;
			}
		}else{
			throw new CargoInvalidoException(Mensagem.erro + Mensagem.cargoInvalido);
		}
		return quantidadeVagas;
	}
	
	public boolean validaDescricao(Cargo cargo) throws CargoInvalidoException{
	
		List<String> cargosValidos = obtemListaDescricoesValidas();
		if(cargosValidos.contains(cargo.getDescricao())){
			result = true;
		}else{
			throw new CargoInvalidoException(Mensagem.cargoInvalido);
		}
		return result;
	}
	
	public boolean validaDocumentoHabilitacao(Cargo cargo) throws DocumentoHabilitacaoException, CargoInvalidoException{
		//valida medico
		if(validaDescricao(cargo)){
			if(cargo.getDescricao().equals(medico) && cargo.getTipoDocumentoHabilitacao() != EnumTipoDocumentoHabilitacao.CRM){
				throw new DocumentoHabilitacaoException(Mensagem.tipoDocumentoCRM);
				//valida engenheiro
			}else if(cargo.getDescricao().equals(engenheiro) && cargo.getTipoDocumentoHabilitacao() != EnumTipoDocumentoHabilitacao.CREA){
				throw new DocumentoHabilitacaoException(Mensagem.tipoDocumentoCREA);
				//valida motorista
			}else if(cargo.getDescricao().equals(motorista) && cargo.getTipoDocumentoHabilitacao() != EnumTipoDocumentoHabilitacao.CNH){
				throw new DocumentoHabilitacaoException(Mensagem.tipoDocumentoCNH);
				//valida que Técnico em Informática não deve ter nenhum documento de habilitação.
			}else if (cargo.getDescricao().equals(tecnicoInformatica) && (cargo.getTipoDocumentoHabilitacao() ==
					EnumTipoDocumentoHabilitacao.CNH || cargo.getTipoDocumentoHabilitacao() == EnumTipoDocumentoHabilitacao.CREA || cargo.getTipoDocumentoHabilitacao() == EnumTipoDocumentoHabilitacao.CRM)){
				throw new DocumentoHabilitacaoException(Mensagem.documentoTecnicoInformatica);
			}else{
				result = true;
			}
		}

		return result;
	}
	
	public boolean validaSalario(Cargo cargo) throws SalarioInvalidoException, CargoInvalidoException {
		if(validaDescricao(cargo)){
			if(cargo.getDescricao().equals(medico) && (cargo.getSalario() < 8000.00d || cargo.getSalario() > 15000.00d)){
				throw new SalarioInvalidoException(Mensagem.salarioMedico);
			}else if(cargo.getDescricao().equals(engenheiro) && (cargo.getSalario() < 3000.00d || cargo.getSalario() > 10000.00d)){
				throw new SalarioInvalidoException(Mensagem.salarioEngenheiro);
			}else if(cargo.getDescricao().equals(tecnicoInformatica) && (cargo.getSalario() < 1500.00d || cargo.getSalario() > 7000.00d)){
				throw new SalarioInvalidoException(Mensagem.salarioTecnicoInformatica);
			}else if(cargo.getDescricao().equals(motorista) && (cargo.getSalario() < 1000.00d || cargo.getSalario() > 3000.00d)){
				throw new SalarioInvalidoException(Mensagem.salarioMotorista);
			}else{
				result = true;
			}
		}

		return result;
	}

	public boolean ocupaVaga(Cargo cargo, Candidato candidato) throws VagaIndisponivelException{
		if(cargo.getQuantidadeVagas() > 0){
			candidato.setCargo(cargo);
			cargo.setQuantidadeVagas(cargo.getQuantidadeVagas()-1);
			result = true;
		}else{
			throw new VagaIndisponivelException(Mensagem.erro + Mensagem.vagaIndisponivel);
		}
		return result;
	}

    public void configuraQuantidadeVagas(Cargo cargo) throws CargoInvalidoException{

		cargo.setQuantidadeVagas(obtemQuantidadeVagasIncialCargo(cargo));

    }

	public boolean validaQuantidadeVagas(Cargo cargo) throws QuantidadeVagasInvalidaException, CargoInvalidoException{
		if(validaDescricao(cargo)){
			if((cargo.getDescricao().equalsIgnoreCase(medico) && (cargo.getQuantidadeVagas() != obtemQuantidadeVagasIncialCargo(cargo))) ||
					((cargo.getDescricao().equalsIgnoreCase(engenheiro)) && (cargo.getQuantidadeVagas() != obtemQuantidadeVagasIncialCargo(cargo))) ||
					((cargo.getDescricao().equalsIgnoreCase(tecnicoInformatica)) && (cargo.getQuantidadeVagas() != obtemQuantidadeVagasIncialCargo(cargo))) ||
					((cargo.getDescricao().equalsIgnoreCase(motorista)) && (cargo.getQuantidadeVagas() != obtemQuantidadeVagasIncialCargo(cargo)))){
				throw new QuantidadeVagasInvalidaException(Mensagem.erro + Mensagem.quantidadeVagasInvalida);
			}else{
				result = true;
			}
		}
		return result;
	}

	public boolean validaCargo(Cargo cargo) throws Exception{
		if(validaDescricao(cargo)){
			if(validaSalario(cargo)){
				if(validaDocumentoHabilitacao(cargo)){
					if(validaQuantidadeVagas(cargo)){
						result = true;
					}
				}
			}
		}
		return result;
	}

}
