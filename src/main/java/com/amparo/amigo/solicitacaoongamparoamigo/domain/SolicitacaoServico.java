package com.amparo.amigo.solicitacaoongamparoamigo.domain;

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

    private String categoria;

    private String servico;

    private String estado;

    private String cidade;

    private String nomeVoluntario;

    private String razaoSocialOng;

    private String cnpj;

    @Setter
    @JsonProperty("data_criacao")
    private String datacriacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss"));

    public SolicitacaoServico() { super(); }

    @JsonCreator
    public SolicitacaoServico( @JsonProperty("categoria") String categoria,
                               @JsonProperty("servico") String servico,
                               @JsonProperty("estado") String estado,
                               @JsonProperty("cidade") String cidade,
                               @JsonProperty("nome_voluntario") String nomeVoluntario,
                               @JsonProperty("razao_social_ong") String razaoSocialOng,
                               @JsonProperty("cnpj") String cnpj)
    {
        this.categoria = categoria;
        this.servico = servico;
        this.estado = estado;
        this.cidade = cidade;
        this.nomeVoluntario = nomeVoluntario;
        this.razaoSocialOng = razaoSocialOng;
        this.cnpj = cnpj;
    }
}
