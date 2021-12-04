package com.amparo.amigo.solicitacaoongamparoamigo.service;

import com.amparo.amigo.solicitacaoongamparoamigo.domain.SolicitacaoServico;
import com.amparo.amigo.solicitacaoongamparoamigo.exceptions.SolicitacaoServicoNotFoundException;
import com.amparo.amigo.solicitacaoongamparoamigo.repository.SolicitacaoServicoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SolicitacaoSevicoService {

    private SolicitacaoServicoRepository repository;
    public SolicitacaoSevicoService(SolicitacaoServicoRepository repository) { this.repository = repository; }

    public SolicitacaoServico criarSolicitacao(SolicitacaoServico solicitacao){
        return repository.save(solicitacao);
    }

    public Optional<SolicitacaoServico> consultarServicoId(Integer solicitacaoId){

        var consultaSolicitacaoServico = repository.findBySolicitacaoId(solicitacaoId).isPresent();

        if(!consultaSolicitacaoServico){
            throw new SolicitacaoServicoNotFoundException("Não encontrada id da solicitacao: " + solicitacaoId);
        }

        return repository.findBySolicitacaoId(solicitacaoId);

    }

}
