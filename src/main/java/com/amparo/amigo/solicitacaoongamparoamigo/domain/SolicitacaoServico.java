package com.amparo.amigo.solicitacaoongamparoamigo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "solicitacao_servico")
public class SolicitacaoServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao")
    private Integer solicitacaoId;

    private String categoria;

    private String servico;

    private String estado;

    private String cidade;

    @Column(name = "nome_voluntario")
    private String nomeVoluntario;

    @Column(name = "razao_social_ong")
    private String razaoSocialOng;

    private Integer cnpj;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public SolicitacaoServico() { super(); }

    @JsonCreator
    public SolicitacaoServico( @JsonProperty("categoria") String categoria,
                               @JsonProperty("servico") String servico,
                               @JsonProperty("estado") String estado,
                               @JsonProperty("cidade") String cidade,
                               @JsonProperty("nome_voluntario") String nomeVoluntario,
                               @JsonProperty("razao_social_ong") String razaoSocialOng,
                               @JsonProperty("cnpj") Integer cnpj)
    {
        this.categoria = categoria;
        this.servico = servico;
        this.estado = estado;
        this.cidade = cidade;
        this.nomeVoluntario = nomeVoluntario;
        this.razaoSocialOng = razaoSocialOng;
        this.cnpj = cnpj;
    }


    public void setSolicitacaoId(Integer solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNomeVoluntario(String nomeVoluntario) {
        this.nomeVoluntario = nomeVoluntario;
    }

    public void setRazaoSocialOng(String razaoSocialOng) {
        this.razaoSocialOng = razaoSocialOng;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = LocalDateTime.now();
    }
}
