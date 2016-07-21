package recursosHumanos.negocio;

import org.junit.Test;
import recursosHumanos.entidade.Candidato;
import recursosHumanos.entidade.Cargo;
import recursosHumanos.enumeradores.EnumSexo;
import recursosHumanos.enumeradores.EnumTipoDocumentoHabilitacao;
import recursosHumanos.enumeradores.EnumTipoDocumentoPessoal;
import recursosHumanos.enumeradores.EnumTipoNacionalidade;
import recursosHumanos.excecoes.CPFInvalidoException;
import recursosHumanos.excecoes.NomeInvalidoException;
import recursosHumanos.excecoes.PassaporteInvalidoException;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Tiago on 20/07/2016.
 *
 * Referente ao caso de teste 08
 */
public class CandidatoNegTest {
    @Test(expected = NomeInvalidoException.class)
    public void nomeMaior100() throws Exception {
        Cargo cargo = new Cargo("Estudante", 900.00, EnumTipoDocumentoHabilitacao.CNH, 35);
        Candidato candidato = new Candidato(
                "Pedro de Alcântara João Carlos Leopoldo Salvador Bibiano Francisco Xavier de Paula Leocádio Miguel Gabriel Rafael Gonzaga de Bragança e Bourbon",
                new Date(29,02,1996),
                EnumSexo.M,
                EnumTipoNacionalidade.BRASILEIRA,
                EnumTipoDocumentoPessoal.CPF,
                "6541651631",
                "12345678910",
                "",
                "123456");
        CandidatoNeg candidatoNeg = new CandidatoNeg();
        candidatoNeg.validaNome(candidato);
    }

    @Test(expected = NomeInvalidoException.class)
    public void nomeMenor5() throws Exception {
        Cargo cargo = new Cargo("Estudante", 900.00, EnumTipoDocumentoHabilitacao.CNH, 35);
        Candidato candidato = new Candidato(
                "Aaaa",
                new Date(29,02,1996),
                EnumSexo.M,
                EnumTipoNacionalidade.BRASILEIRA,
                EnumTipoDocumentoPessoal.CPF,
                "6541651631",
                "12345678910",
                "",
                "123456");
        CandidatoNeg candidatoNeg = new CandidatoNeg();
        candidatoNeg.validaNome(candidato);
    }

    @Test(expected = NomeInvalidoException.class)
    public void nomeNulo() throws Exception {
        Candidato candidato = new Candidato(
                null,
                new Date(29,02,1996),
                EnumSexo.M,
                EnumTipoNacionalidade.BRASILEIRA,
                EnumTipoDocumentoPessoal.CPF,
                "6541651631",
                "12345678910",
                "",
                "123456");
        CandidatoNeg candidatoNeg = new CandidatoNeg();
        candidatoNeg.validaNome(candidato);
    }

    @Test(expected = NomeInvalidoException.class)
    public void nomeCaracter() throws Exception {
        Candidato candidato = new Candidato(
                "Mim_Acher",
                new Date(29,02,1996),
                EnumSexo.M,
                EnumTipoNacionalidade.BRASILEIRA,
                EnumTipoDocumentoPessoal.CPF,
                "6541651631",
                "12345678910",
                "",
                "123456");
        CandidatoNeg candidatoNeg = new CandidatoNeg();
        candidatoNeg.validaNome(candidato);
    }

    @Test(expected = CPFInvalidoException.class)
    public void cpfInvalido() throws Exception {
        Candidato candidato = new Candidato(
                "Mim Acher",
                new Date(29,02,1996),
                EnumSexo.M,
                EnumTipoNacionalidade.BRASILEIRA,
                EnumTipoDocumentoPessoal.CPF,
                "6541651631",
                "1245678910",
                "",
                "123456");
        CandidatoNeg candidatoNeg = new CandidatoNeg();
        candidatoNeg.validarCPF(candidato);
    }

    @Test(expected = CPFInvalidoException.class)
    public void cpfNulo() throws Exception {
        Candidato candidato = new Candidato(
                "Mim Acher",
                new Date(29,02,1996),
                EnumSexo.M,
                EnumTipoNacionalidade.BRASILEIRA,
                EnumTipoDocumentoPessoal.CPF,
                "6541651631",
                null,
                "",
                "123456");
        CandidatoNeg candidatoNeg = new CandidatoNeg();
        assertFalse(candidatoNeg.validarCPF(candidato));
    }

}