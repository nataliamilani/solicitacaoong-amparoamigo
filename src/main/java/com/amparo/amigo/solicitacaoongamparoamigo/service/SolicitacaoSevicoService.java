package com.amparo.amigo.solicitacaoongamparoamigo.service;

import com.amparo.amigo.solicitacaoongamparoamigo.domain.SolicitacaoServico;
import com.amparo.amigo.solicitacaoongamparoamigo.exceptions.SolicitacaoServicoNotFoundException;
import com.amparo.amigo.solicitacaoongamparoamigo.repository.SolicitacaoServicoRepository;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoSevicoService {

    private SolicitacaoServicoRepository repository;
    public SolicitacaoSevicoService(SolicitacaoServicoRepository repository) { this.repository = repository; }

    public SolicitacaoServico criarSolicitacao(SolicitacaoServico solicitacao){
        return repository.save(solicitacao);
    }

    public SolicitacaoServico consultarServicoId(Integer solicitacaoId){
        try {
            return repository.findByIdSolicitacao(solicitacaoId);
        } catch (RuntimeException runtimeException) {
            throw new SolicitacaoServicoNotFoundException("Não encontrada id da solicitacao: " + solicitacaoId);
        }
    }

}
