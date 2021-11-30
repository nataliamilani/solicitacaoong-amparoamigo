package com.amparo.amigo.solicitacaoongamparoamigo.repository;

import com.amparo.amigo.solicitacaoongamparoamigo.domain.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoServicoRepository extends JpaRepository<SolicitacaoServico, Integer> {

    SolicitacaoServico findBySolicitacaoId(Integer solicitacaoId);
}
