package com.amparo.amigo.solicitacaoongamparoamigo.service;

import com.amparo.amigo.solicitacaoongamparoamigo.domain.SolicitacaoServico;
import com.amparo.amigo.solicitacaoongamparoamigo.exceptions.SolicitacaoNotFoundException;
import com.amparo.amigo.solicitacaoongamparoamigo.repository.SolicitacaoServicoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SolicitacaoSevicoService {

    private SolicitacaoServicoRepository repository;
    public SolicitacaoSevicoService(SolicitacaoServicoRepository repository) { this.repository = repository; }

    public SolicitacaoServico criarSolicitacao(SolicitacaoServico solicitacao){
        return repository.save(solicitacao);
    }

    public Optional<SolicitacaoServico> consultarSolicitacaoBySolicitacaoId(Integer solicitacaoId){

        var consultaSolicitacaoServico = repository.findBySolicitacaoId(solicitacaoId).isPresent();

        if(!consultaSolicitacaoServico){
            throw new SolicitacaoNotFoundException("Não encontrada id da solicitacao: " + solicitacaoId);
        }

        return repository.findBySolicitacaoId(solicitacaoId);

    }

    public List<SolicitacaoServico> consultarSolicitacaoByVoluntarioId(Integer voluntarioId){

        var consultaSolicitacao = repository.findByVoluntarioId(voluntarioId);

        if(consultaSolicitacao.isEmpty()){
            throw new SolicitacaoNotFoundException("Não encontrada solicitacao para esse voluntario Id: " + voluntarioId);
        }

        return repository.findByVoluntarioId(voluntarioId);

    }

}
