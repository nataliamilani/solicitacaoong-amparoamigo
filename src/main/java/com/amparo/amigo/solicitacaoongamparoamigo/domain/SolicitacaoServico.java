package com.amparo.amigo.solicitacaoongamparoamigo.domain;

import com.amparo.amigo.solicitacaoongamparoamigo.exceptions.CnpjOuCpfInvalidoException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Getter
@Entity
@Table(name = "solicitacao_servico")
public class SolicitacaoServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer solicitacaoId;

    private Integer voluntarioId;

    private String categoria;

    private String estado;

    private String cidade;

    private String razaoSocial;

    private String cpfCnpj;

    private String responsavel;

    private String telefone;

    private String digaAlgoAoVoluntario;

    @Setter
    @JsonProperty("dataCriacao")
    private String datacriacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss"));

    public SolicitacaoServico() { super(); }

    @JsonCreator
    public SolicitacaoServico( @JsonProperty("voluntarioId") Integer voluntarioId,
                               @JsonProperty("categoria") String categoria,
                               @JsonProperty("estado") String estado,
                               @JsonProperty("cidade") String cidade,
                               @JsonProperty("razaoSocial") String razaoSocial,
                               @JsonProperty("cpfCnpj") String cpfCnpj,
                               @JsonProperty("responsavel") String responsavel,
                               @JsonProperty("telefone") String telefone,
                               @JsonProperty("digaAlgoAoVoluntario") String digaAlgoAoVoluntario)
    {
        this.voluntarioId = voluntarioId;
        this.categoria = categoria;
        this.estado = estado;
        this.cidade = cidade;
        this.razaoSocial = razaoSocial;
        setCpfCnpj(cpfCnpj);
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.digaAlgoAoVoluntario = digaAlgoAoVoluntario;
    }

    public void setCpfCnpj(String cpfCnpj) {

        if (isValid(cpfCnpj)) {
            this.cpfCnpj = cpfCnpj;
        } else {
            throw new CnpjOuCpfInvalidoException("Favor preencher um CPF ou CNPJ v??lido");
        }
    }

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static boolean isValid(String cpfCnpj) {
        return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    private static String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private static boolean isValidCPF(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");
        if ((cpf==null) || (cpf.length()!=11)) return false;

        for (int j = 0; j < 10; j++)
            if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf))
                return false;

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }

    private static boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.trim().replace(".", "").replace("-", "");
        if ((cnpj==null)||(cnpj.length()!=14)) return false;

        Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
    }

}
